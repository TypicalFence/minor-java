package moe.zaun.prismriver.minor.service.mongodb;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import moe.zaun.prismriver.minor.model.Song;
import moe.zaun.prismriver.minor.service.interfaces.SongService;
import org.bson.BsonValue;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

public class MongoSongService implements SongService {

    private final MongoDatabase db;

    @Inject
    public MongoSongService(final MongoClient db) {
        this.db = db.getDatabase("minor");
    }

    private MongoCollection<MongoSong> getCollection() {
        return this.db.getCollection("songs", MongoSong.class);
    }

    @Override
    public Optional<String> addSong(Song song) {
        MongoCollection<MongoSong> collection = this.getCollection();
        MongoSong mongoSong = new MongoSong(song);
        InsertOneResult result = collection.insertOne(mongoSong);
        BsonValue id = result.getInsertedId();

        if (id == null) {
            return Optional.absent();
        }

        String objectId = id.asObjectId().getValue().toHexString();
        return Optional.of(objectId);
    }

    @Override
    public Optional<Song> getSongById(String id) {
        ObjectId objectId;

        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException _e) {
            return Optional.absent();
        }

        MongoCollection<MongoSong> collection = this.getCollection();
        MongoSong songDocument = collection.find(eq("_id", objectId)).first();
        if (songDocument == null) {
            return Optional.absent();
        }

        return Optional.of(songDocument.getSong());
    }

    @Override
    public int getSongCount() {
        MongoCollection<MongoSong> collection = this.getCollection();
        return (int) collection.countDocuments();
    }

    @Override
    public List<Song> getSongs() {
        return this.getSongs(0);
    }

    @Override
    public List<Song> getSongs(int start) {
        return this.getSongs(start, LIMIT);
    }

    @Override
    public List<Song> getSongs(int start, int limit) {
        MongoCollection<MongoSong> collection = this.getCollection();
        ArrayList<MongoSong> mongoSongs = collection.find()
                .skip(start)
                .limit(limit)
                .into(new ArrayList<>());

        return mongoSongs.stream()
                .map((MongoSong x) -> x.getSong())
                .collect(Collectors.toList());
    }
}

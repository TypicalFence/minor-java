package moe.zaun.prismriver.minor.service.mongodb;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import moe.zaun.prismriver.minor.model.Song;
import moe.zaun.prismriver.minor.service.interfaces.SongService;
import org.apache.commons.lang3.NotImplementedException;
import org.bson.BsonValue;

import java.util.List;

public class MongoSongService implements SongService {

    private final MongoClient mongo;
    private final MongoDatabase db;

    @Inject
    public MongoSongService(final MongoClient db) {
        this.mongo = db;
        this.db = mongo.getDatabase("minor");
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getSongCount() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<Song> getSongs() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<Song> getSongs(int start) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<Song> getSongs(int start, int limit) {
        throw new NotImplementedException("TODO");
    }
}

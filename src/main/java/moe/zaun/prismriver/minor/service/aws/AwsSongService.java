package moe.zaun.prismriver.minor.service.aws;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.Select;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import moe.zaun.prismriver.minor.model.Song;
import moe.zaun.prismriver.minor.service.interfaces.SongService;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class AwsSongService implements SongService {
    
    private final AmazonDynamoDB db;
    private final DynamoDBMapper mapper;

    @Inject
    public AwsSongService(final AmazonDynamoDB db) {
        this.db = db;
        this.mapper = new DynamoDBMapper(this.db);
    }

    public Optional<String> addSong(Song song) {
        AwsSong awsSong = new AwsSong(song);
        this.mapper.save(awsSong);
        return Optional.of(awsSong.getId());
    }

    public Optional<Song> getSongById(String id) {
        AwsSong awsSong = this.mapper.load(AwsSong.class, id);

        if (awsSong == null) {
            return Optional.absent();
        }

        return Optional.of(awsSong.getSong());
    }

    public int getSongCount() {
        return this.mapper.count(AwsSong.class, new DynamoDBScanExpression().withSelect(Select.COUNT));
    }

    public List<Song> getSongs() {
        throw new NotImplementedException("TODO");
    }

    public List<Song> getSongs(int start) {
        throw new NotImplementedException("TODO");
    }

    public List<Song> getSongs(int start, int limit) {
        throw new NotImplementedException("TODO");
    }
}

package moe.zaun.prismriver.minor.service.aws;

import java.util.List;
import org.apache.commons.lang3.NotImplementedException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import moe.zaun.prismriver.minor.model.Song;
import moe.zaun.prismriver.minor.service.interfaces.SongService;

public class AwsSongService implements SongService {
    
    AmazonDynamoDB db;
    DynamoDBMapper mapper;

    public AwsSongService() {
        this.db = AmazonDynamoDBClientBuilder
            .standard()
            .withRegion("us-east-2")
            .build();
        this.mapper = new DynamoDBMapper(this.db);
    }

    public void addSong(Song song) {
        AwsSong awsSong = new AwsSong(song);
        this.mapper.save(awsSong);
    }

    public Song getSongById(String id) {
        throw new NotImplementedException("TODO");
    }

    public int getSongCount() {
        throw new NotImplementedException("TODO");
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

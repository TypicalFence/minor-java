package moe.zaun.prismriver.minor.service.aws;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import moe.zaun.prismriver.minor.model.Song;

@DynamoDBTable(tableName="Songs")
public class AwsSong {
    private Song song;

    public AwsSong(Song song) {
        this.song = song;
    }

    @DynamoDBHashKey(attributeName="id")  
    public String getId() { 
        return this.song.id; 
    }

    public void setId(String id) {
        this.song.id = id;
    }

    @DynamoDBAttribute(attributeName="title")  
    public String getTitle() { 
        return this.song.title; 
    }

    public void setTitle(String title) {
        this.song.title = title;
    }

    @DynamoDBAttribute(attributeName="artist")  
    public String getArtist() { 
        return this.song.artist; 
    }

    public void setArtist(String artist) {
        this.song.artist = artist;
    }

    @DynamoDBAttribute(attributeName="year")  
    public String getYear() { 
        return this.song.year; 
    }

    public void setYear(String year) {
        this.song.year = year;
    }

    @DynamoDBAttribute(attributeName="track")  
    public Integer getTrack() { 
        return this.song.track; 
    }

    public void setTrack(Integer track) {
        this.song.track = track;
    }
}

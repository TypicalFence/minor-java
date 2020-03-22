package moe.zaun.prismriver.minor.service.aws;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import moe.zaun.prismriver.minor.model.Song;

import java.util.UUID;

@DynamoDBTable(tableName="Songs")
public class AwsSong {
    private Song song;

    public AwsSong() {
        this(new Song());
    }

    public AwsSong(Song song) {
        this.song = song;

        // generate ID if it doesn't have one yet
        if (this.song.id == null) {
            this.song.id = UUID.randomUUID().toString().replace("-", "");
        }
    }

    @DynamoDBIgnore
    public Song getSong() {
        return song;
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
        return this.song.albumInfo.track;
    }

    public void setTrack(Integer track) {
        this.song.albumInfo.track = track;
    }

    @DynamoDBAttribute(attributeName="album")
    public String getAlbum() {
        return this.song.albumInfo.album;
    }

    public void setAlbum(String album) {
        this.song.albumInfo.album = album;
    }

    @DynamoDBAttribute(attributeName="album_artist")
    public String getAlbumArtist() {
        return this.song.albumInfo.albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.song.albumInfo.albumArtist = albumArtist;
    }
}

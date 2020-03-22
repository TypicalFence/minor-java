package moe.zaun.prismriver.minor.service.mongodb;

import moe.zaun.prismriver.minor.model.Song;
import org.bson.types.ObjectId;

public class MongoSong {
    private Song song;

    public MongoSong() {
        this.song = new Song();
    }

    public MongoSong(Song song) {
        this.song = song;
    }

    public ObjectId getId() {
        try {
            return new ObjectId(song.id);
        } catch (IllegalArgumentException _e) {
            return null;
        }
    }

    public boolean setId(final ObjectId id) {
        this.song.id = id.toHexString();
        return true;
    }

    public String getTitle() {
        return this.song.title;
    }

    public void setTitle(final String title) {
        this.song.title = title;
    }

    public String getArtist() {
        return this.song.artist;
    }

    public void setArtist(final String artist) {
        this.song.artist = artist;
    }

    public String getYear() {
        return this.song.year;
    }

    public void setYear(final String year) {
        this.song.year = year;
    }

    public String getGenre() {
        return this.song.genre;
    }

    public void setGenre(final String genre) {
        this.song.genre = genre;
    }

    public String getAlbum() {
        return this.song.albumInfo.album;
    }

    public void setAlbum(final String album) {
        this.song.albumInfo.album = album;
    }

    public String getAlbumArtist() {
        return this.song.albumInfo.albumArtist;
    }

    public void setAlbumArtist(final String album) {
        this.song.albumInfo.albumArtist = album;
    }

    public Integer getTrack() {
        return this.song.albumInfo.track;
    }

    public void setTrack(final int track) {
        this.song.albumInfo.track = track;
    }
}

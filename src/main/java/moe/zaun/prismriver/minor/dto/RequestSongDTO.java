package moe.zaun.prismriver.minor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import moe.zaun.prismriver.minor.model.Song;

// TODO add validation
public class RequestSongDTO {
    public String title;
    public String artist;
    public String year;
    public int track;
    public String album;

    @JsonProperty("album_artist")
    public String albumArtist;
    public String genre;

    public Song toModel() {
        Song song = new Song();
        song.title = this.title;
        song.artist = this.artist;
        song.year = this.year;
        song.genre = this.genre;

        // the python implementation currently doesn't do any more validation than this,
        // so this should be fine for the moment
        if (this.album != null) {
            song.albumInfo.album = this.album;
            song.albumInfo.track = this.track;
            song.albumInfo.albumArtist = this.albumArtist;
        }

        return song;
    }
}

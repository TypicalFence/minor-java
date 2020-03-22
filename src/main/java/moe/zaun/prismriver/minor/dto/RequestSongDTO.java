package moe.zaun.prismriver.minor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import moe.zaun.prismriver.minor.model.Song;

import java.util.Objects;
import java.util.stream.Stream;

public class RequestSongDTO implements RequestDTO {
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

        if (this.album != null) {
            song.albumInfo.album = this.album;
            song.albumInfo.track = this.track;
            song.albumInfo.albumArtist = this.albumArtist;
        }

        return song;
    }

    @Override
    public boolean isValid() {
        // we could have used JSR 380
        // but thanks to some conditional cases
        // that would result in much more code and complexity

        // genre is optional
        boolean validBase = !Stream.of(this.title, this.artist, this.year).anyMatch(Objects::isNull);

        if (this.album != null) {
            boolean validAlbum = !Stream.of(this.album, this.track, this.albumArtist).anyMatch(Objects::isNull);
            return validBase && validAlbum;
        }

        return validBase;
    }
}

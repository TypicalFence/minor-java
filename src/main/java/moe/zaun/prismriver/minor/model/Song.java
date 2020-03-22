package moe.zaun.prismriver.minor.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Song extends Model {
    public String title;
    public String artist;
    public String year;
    public String genre;
    public int playTime;

    @JsonUnwrapped
    public AlbumInfo albumInfo;

    public Song() {
        this.albumInfo = new AlbumInfo();
    }
}

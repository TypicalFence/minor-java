package moe.zaun.prismriver.minor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Song extends Model {
    public String title;
    public String artist;
    public String year;

    @JsonInclude(Include.NON_NULL)
    public String genre;
    public int playTime;

    @JsonUnwrapped
    public AlbumInfo albumInfo;

    public Song() {
        this.albumInfo = new AlbumInfo();
    }
}

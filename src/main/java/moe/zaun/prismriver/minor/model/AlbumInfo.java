package moe.zaun.prismriver.minor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AlbumInfo {
    @JsonInclude(Include.NON_NULL)
    public Integer track;

    @JsonInclude(Include.NON_NULL)
    public String album;

    @JsonInclude(Include.NON_NULL)
    public String albumArtist;
}

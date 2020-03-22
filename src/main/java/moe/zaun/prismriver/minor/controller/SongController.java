package moe.zaun.prismriver.minor.controller;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import moe.zaun.prismriver.minor.dto.ApiResponse;
import moe.zaun.prismriver.minor.dto.RequestSongDTO;
import moe.zaun.prismriver.minor.dto.SimpleApiResponse;
import moe.zaun.prismriver.minor.dto.StatusApiResponse;
import moe.zaun.prismriver.minor.model.Created;
import moe.zaun.prismriver.minor.model.Song;
import moe.zaun.prismriver.minor.service.interfaces.SongService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/v1/music")
public class SongController {

    private final SongService songService;

    @Inject
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @POST
    @Path("/songs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse postSong(RequestSongDTO postedSong) {
        Song song = postedSong.toModel();
        Optional<String> id = this.songService.addSong(song);

        if (!id.isPresent()) {
            return StatusApiResponse.internalError();
        }

        SimpleApiResponse response = new SimpleApiResponse();
        response.setStatus(200);
        response.setMessage("ok");
        response.setData(new Created(id.get()));
        return response;
    }
}

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

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("api/v1/music/songs")
public class SongController {

    private final SongService songService;

    @Inject
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @POST
    @Path("/")
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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Song getSongById(@PathParam("id") String id) {
        Song song = this.songService.getSongById(id);
        return song;
    }
}

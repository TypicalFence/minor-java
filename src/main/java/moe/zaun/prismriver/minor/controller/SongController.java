package moe.zaun.prismriver.minor.controller;


import com.google.common.base.Optional;
import com.google.inject.Inject;
import moe.zaun.prismriver.minor.dto.ListApiResponse;
import moe.zaun.prismriver.minor.dto.RequestSongDTO;
import moe.zaun.prismriver.minor.model.Created;
import moe.zaun.prismriver.minor.model.Model;
import moe.zaun.prismriver.minor.model.Song;
import moe.zaun.prismriver.minor.service.interfaces.SongService;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


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
    public Created postSong(RequestSongDTO postedSong) {
        if (!postedSong.isValid()) {
            throw new BadRequestException();
        }

        Song song = postedSong.toModel();

        Optional<String> id = this.songService.addSong(song);

        if (!id.isPresent()) {
            throw new InternalServerErrorException();
        }

        return new Created(id.get());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Song getSongById(@PathParam("id") String id) {
        Optional<Song> song = this.songService.getSongById(id);

        if (!song.isPresent()) {
            throw new NotFoundException();
        }

        return song.get();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ListApiResponse getSongs(@QueryParam("start") Integer start) {
        List<Song> songs;
        int count;

        if (start == null) {
            songs = this.songService.getSongs();
        } else  {
            songs = this.songService.getSongs(start);
        }

        count = this.songService.getSongCount();

        // SCREAMS IN JAVA
        List<Model> models = new ArrayList<>(songs);

        ListApiResponse response = new ListApiResponse();
        response.setMessage("ok");
        response.setStatus(200);
        response.setData(models);
        response.setCount(count);
        response.setLimit(this.songService.LIMIT);
        return response;
    }
}

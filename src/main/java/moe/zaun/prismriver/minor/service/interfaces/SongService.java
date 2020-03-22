package moe.zaun.prismriver.minor.service.interfaces;

import com.google.common.base.Optional;
import moe.zaun.prismriver.minor.model.Song;

import java.util.List;

public interface SongService {
    int LIMIT = 20;

    /**
     * Adds a Song
     * @param song The Song to add
     * @return The ID of the newly created song if successful
     */
    Optional<String> addSong(Song song);


    /**
     * Looks up a Song
     * @param id The ID of the Song to lookup
     * @return The Requested song if found
     */
    Optional<Song> getSongById(String id);

    /**
     * Gets the Amount of Songs known to the service
     * @return The number of Songs
     */
    int getSongCount();

    List<Song> getSongs();
    List<Song> getSongs(int start);
    List<Song> getSongs(int start, int limit);
}

package moe.zaun.prismriver.minor.service.interfaces;

import com.google.common.base.Optional;
import moe.zaun.prismriver.minor.model.Song;

import java.util.List;

public interface SongService {
    public Optional<String> addSong(Song song);
    public Song getSongById(String id);
    public int getSongCount();
    public List<Song> getSongs();
    public List<Song> getSongs(int start);
    public List<Song> getSongs(int start, int limit);
}

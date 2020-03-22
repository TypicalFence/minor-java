package moe.zaun.prismriver.minor.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RequestSongDTOTest {

    @Test
    public void isValidSimple() {
        RequestSongDTO song = new RequestSongDTO();
        song.title = "Bad apple";
        song.artist = "nomico";
        song.year = "2004";

        assertTrue("should be valid", song.isValid());
    }

    @Test
    public void isValidSimpleWithGenre() {
        RequestSongDTO song = new RequestSongDTO();
        song.title = "Bad apple";
        song.artist = "nomico";
        song.year = "2004";
        song.genre = "doujin";

        assertTrue("should be valid", song.isValid());
    }

    @Test
    public void isValidFull() {
        RequestSongDTO song = new RequestSongDTO();
        song.title = "Bad apple";
        song.artist = "nomico";
        song.year = "2004";
        song.albumArtist = "Alstroemeria Records";
        song.album = "bad apple EP";
        song.track = 1;

        assertTrue("should be valid", song.isValid());
    }
}
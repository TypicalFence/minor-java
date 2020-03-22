package moe.zaun.prismriver.minor.service.aws;

import moe.zaun.prismriver.minor.model.Song;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AwsSongTest {

    @Test
    public void canBeCreated() {
        Song song = new Song();
        song.title = "Bad Apple";
        song.year = "2004";
        song.artist = "nomico";

        AwsSong awsSong = new AwsSong(song);
        assertEquals("should have the same title as the song", awsSong.getTitle(), song.title);
        assertEquals("should have the same title as the artist", awsSong.getArtist(), song.artist);
    }

    @Test
    public void willGenerateIdWhenMissing() {
        Song song = new Song();
        AwsSong awsSong = new AwsSong(song);
        assertNotNull("should generate an id when the song does not have one yet", awsSong.getId());
    }

    @Test
    public void willNotOverwriteId() {
        Song song = new Song();
        song.id = "my cool id";
        AwsSong awsSong = new AwsSong(song);
        assertEquals("must not overwrite an already existing id", awsSong.getId(), "my cool id");
    }
}
import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class MusicPlayer extends Player {
    private String voice = "";
    public MusicPlayer(){}
    public MusicPlayer(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public void play(Song track) {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("say " + "now playing..." + track.getTitle() + " by " + track.getArtist());
            sleep(INTRO_PAUSE);
            for (String lyric : track.getLyrics()) {
                if (voice.isEmpty()) {
                    r.exec("say " + lyric);
                } else {
                    r.exec("say -v" + voice + " " + lyric);
                }
                sleep(WORD_CADENCE);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play(Album track) {
        for (Song song : track.getSong()) {
            this.play(song);
        }
    }
}

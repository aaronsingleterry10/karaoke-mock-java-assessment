import java.util.List;

public class Album {
    private String name;
    private List<Song> song;

    public Album(String name, List<Song> song) {
        this.name = name;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    public void printTrackListings() {
        System.out.println("90s HITS track listing...");
        for (Song track : this.song) {
            System.out.println(track);
        }
    }
}

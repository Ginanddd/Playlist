package Playlist;


public class LoopingPlaylist extends Playlist {

    public LoopingPlaylist(Song data) {
        super(data);
    }

    public LoopingPlaylist() {
        super();
    }

    public int getTotalDuration(int loops) {
        return super.getTotalDuration() * loops;
    }
}
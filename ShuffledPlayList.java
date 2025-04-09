package Playlist;

import java.util.LinkedHashSet;
import java.util.Set;

public class ShuffledPlayList extends Playlist {

    public ShuffledPlayList(Song data) {
        super(data);
    }

    public ShuffledPlayList() {
        super();
    }

    @Override
    public void displayPlaylist() {
        Song[] songs = toArr();
        Set<Integer> set = new LinkedHashSet<>();
        

        while (set.size() < songs.length) {
            int randIndex =  (int) (Math.random() * songs.length);

            set.add(randIndex);
        
        }

        int i = 0;
        for (int nums : set) {
            System.out.println(songs[nums]);
            i++;
            
            if (i != set.size()) System.out.println("------------------");
        }

        
    }
    
    private Song[] toArr () {
        Song[] song = new Song[songCount];

        Node temp = head;
        for (int i = 0; i < songCount; i++) {
            song[i] = temp.data;

            temp = temp.next;
        }

        return song;
    }

    
}

package Playlist;

public class Playlist {
    Node head;
    Node tail;
    int songCount = 0;

    public Playlist (Song data) {
        head = new Node (data);
        tail = new Node (data);
        ++songCount;
    }

    public Playlist() {
        head = null;
        tail = null;
        songCount = 0;
    }

    private boolean contains (String title) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.getTitle().equalsIgnoreCase(title))
                return true;
            
            temp = temp.next;
        }

        return false;
    }

    public boolean add_song (Song data) {
        if (contains(data.getTitle()))
            return false;

        Node node = new Node(data);
        if (head == null && tail == null) {
            head = node;
            tail = node;
            ++songCount;

            return true;
        }

        tail.next = node;
        tail = tail.next;

        ++songCount;
        return true;
    }

    public Song remove_song (String title) {
        if (head == null && tail == null) return null;

        Node temp = head;
        Song songTemp = temp.data;

        if (temp.data.getTitle().equalsIgnoreCase(title)) {
            head = head.next;
            --songCount;

            return songTemp;
        } 

        while (temp.next != null) {
            if (temp.next.data.getTitle().equalsIgnoreCase(title)) {
                songTemp = temp.next.data;
                temp.next = temp.next.next;
                return songTemp;
            }

            temp = temp.next;
        }

        --songCount;

        return null;
    } 

    public void displayPlaylist() {
        if (songCount == 0) {
            System.out.println("Playlist is empty");

            return;
        }

        Node temp = head;

        while (temp != null) {
            
            System.out.println(temp.data);
            if (temp.next != null) System.out.println("------------");

            temp = temp.next;
        }
    }

    public int getTotalDuration() {
        if (head == null && tail == null) return 0;

        Node temp = head;

        int count = 0;

        while (temp != null) {
            count += temp.data.getDuration();

            temp = temp.next;
        }

        return count;

    }
    
    public static void main(String[] args) {
        Playlist pl = new Playlist();

        pl.add_song(new Song("Shape of You", "Ed Sheeran", 240));
        pl.add_song(new Song("Blinding Lights", "The Weeknd", 200));
        pl.add_song(new Song("Levitating", "Dua Lipa", 220));
        
        pl.displayPlaylist();

        ShuffledPlayList spl = new ShuffledPlayList();

        System.out.println("\nShuffled \n");

         spl.add_song(new Song("Shape of You", "Ed Sheeran", 240));
        spl.add_song(new Song("Blinding Lights", "The Weeknd", 200));
        spl.add_song(new Song("Levitating", "Dua Lipa", 220));
        spl.displayPlaylist();
        


        System.out.println("\nLooping\n");
        LoopingPlaylist lpl = new LoopingPlaylist();
        lpl.add_song(new Song("Shape of You", "Ed Sheeran", 240));
        lpl.add_song(new Song("Blinding Lights", "The Weeknd", 200));
        lpl.add_song(new Song("Levitating", "Dua Lipa", 220));
        lpl.displayPlaylist();
        System.out.println(lpl.getTotalDuration(4));


    }
}

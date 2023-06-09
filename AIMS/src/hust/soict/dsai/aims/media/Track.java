package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable, Comparable<Track> {
    private String title;
    private int length;
    public Track(String title, int length) {
        super();
        this.title = title;
        this.length = length;
    }
    public String getTitle() {
        return this.title;
    }
    public int getLength() {
        return this.length;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Track)) {
            Track obj2 = (Track) obj;
            if (this.title.equals(obj2.getTitle()) && this.length == obj2.getLength()) {
                return true;
            } 
        } else {
            return false;
        }
        return false;
    }

    public String play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("ERROR: Track length is non-positive");
        } else {
            return "Playing DVD: "+ this.getTitle() + "/n" + "DVD length: " + this.getLength();
        }
    }

    
    public int compareTo(Track obj) {
        for (int i = 0; i < this.title.length() && i < obj.getTitle().length(); i++) {
            if ((int) this.title.charAt(i) == (int) obj.getTitle().charAt(i)) {
                continue;
            } else {
                return ((int) this.title.charAt(i) - (int) obj.getTitle().charAt(i));
            }
        }
        if (!(this.title.length() == obj.getTitle().length())) {
            return (this.title.length() - obj.getTitle().length());
        }
        return 0;
    }
}

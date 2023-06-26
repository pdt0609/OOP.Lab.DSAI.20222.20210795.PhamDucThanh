package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.PlayerException;



import java.util.ArrayList;
import java.util.Iterator;



public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    public CompactDisc(String title, String category, String artist, String director, ArrayList<Track> tracks, float cost) {
        setTitle(title);
        setCategory(category);
        this.artist = artist;
        setDirector(director);
        this.tracks = tracks;
        setCost(cost);
    }

    public String getArtist() {
        return this.artist;
    }
    
    public void addTrack(Track track) {
        if (this.tracks.contains(track)) {
            System.out.println("The track is existed in the list of track");
        } else {
            this.tracks.add(track);
            System.out.println("The track is added");
        }
    }

    public void removeTrack(Track track) {
        if (this.tracks.contains(track)) {
            this.tracks.remove(track);
            System.out.println("The track is removed");
        } else {
            System.out.println("The track is not existed in the list of track");
        }
    }
    
    public int getLength() {
        int sum = 0;
        for (Track track: tracks) {
            sum += track.getLength();
        }
        return sum;
    }

    public String play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        } else {
            String str = "";
            str+="The total length of the CD to add is: " + getLength();
            str+="/n";
            str+="Playing CD: " + this.getTitle();
            str+="/n";
            str+="CD length: " + getLength();
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    str+="/n";
                    str += nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
            return str;
        }
    }

    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.artist + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost();
    }

}

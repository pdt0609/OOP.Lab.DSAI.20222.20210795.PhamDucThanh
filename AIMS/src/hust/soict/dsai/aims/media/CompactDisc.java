package hust.soict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> Tracks = new ArrayList<Track>();
	public CompactDisc(String title, String category, String artist, String director, ArrayList<Track> tracks, float cost) {
        setTitle(title);
        setCategory(category);
        this.artist = artist;
        setDirector(director);
        this.Tracks = tracks;
        setCost(cost);
    }
	
	
	public String getArtist() {
		return artist;
	}
	
	public CompactDisc(String artist, ArrayList<String> tracks) {
		super();
		this.artist = artist;
		this.Tracks = Tracks;
	}

	public void addTracks(Track trackName) {
		if (this.Tracks.contains(trackName)) {
			System.out.println("This track is already added!");
		} else {
			this.Tracks.add(trackName);
		}
	}
	
	public void removeTracks(Track trackName) {
		if (this.Tracks.contains(trackName)) {
			this.Tracks.remove(trackName);
		} else {
			System.out.println("This track is not added!");
		}
	}
	public int getLength() {
		int tracklength=0;
		for (int i = 0; i < Tracks.size(); i++) {
			tracklength += Tracks.get(i).getLength();
		}
		return tracklength;
	}
	public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.artist + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost();
    }

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing track: " + this.getArtist());
		System.out.println("Track length: " + this.getLength());
	}
}

package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title) {
        setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        setCategory(category);
        setTitle(title);
        setCost(cost);
    }
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(length, director);
        setCategory(category);
        setTitle(title);
        setCost(cost);
        addnbMedia();
    }
    public String toString() {
        return  "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " - " + getCost();
    }
    public boolean isMatch(String title) {
        String[] parts = this.getTitle().split(" ");
        String[] parts2 = title.split(" ");
        for (String u: parts) {
            for (String v: parts2) {
                if (u.equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        } else {
            return "Playing DVD: " + this.getTitle() + "/nDVD length: " + this.getLength();
        }
    }
}
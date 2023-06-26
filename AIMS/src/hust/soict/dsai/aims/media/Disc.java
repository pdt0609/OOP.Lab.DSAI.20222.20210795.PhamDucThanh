package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    public Disc() {}
    public Disc(int length, String director) {
        this.length = length;
        this.director = director;
    }
    public int getLength() {
        return this.length;
    }
    public String getDirector() {
        return this.director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}

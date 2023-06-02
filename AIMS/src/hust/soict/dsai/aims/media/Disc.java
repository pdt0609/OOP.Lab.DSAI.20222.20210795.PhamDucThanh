package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
	
	public Disc() {
		
	}
	
	public Disc(String director) {
		this.director = director;
	}
	
	public Disc(int length, String director) {
        this.length = length;
        this.director = director;
	}
	
	public Disc(String director, int length, String title, String category, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	public void setLength(int length) {
        this.length = length;
    }
    public void setDirector(String director) {
        this.director = director;
    }
}
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length;
	
	public DigitalVideoDisc() {
	}
	

	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
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
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
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
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}


}

package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	@Override
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

package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	protected String title;
	private String category;	
	private float cost;
    private static int nbMedia = 0;
    private int id = nbMedia + 1;
	public Media() {
		
	}
	public int getId() {
	    return this.id;
	}
	public Media(String title) {
		this.title = title;
	}

	public Media(String title, String category) {
		this(title);
		this.category = category;
	}
	
	public Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	public void addnbMedia() {
        nbMedia += 1;
    }
    public String toString() {
        return "Id " + getId() + ". Media - " + getTitle() + " - " + getCategory() + ": " + getCost();
    }
    public boolean isMatch(String title) {
        String[] parts = this.title.split(" ");
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
	public boolean equals(Object obj) {
		if (!(obj instanceof Media)) {
			return false;
		}
		else {
			Media thisObj = (Media) obj;
			if (thisObj.getTitle() == this.title) {
				return true;
			} else {
				return false;
			}
		}
	}
		public static final Comparator<Media> COMPARE_BY_TITLE_COST=
				new MediaComparatorByTitleCost();
		public static final Comparator<Media> COMPARE_BY_COST_TITLE=
				new MediaComparatorByCostTitle();
	

}

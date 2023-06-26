package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;
public abstract class Media implements Comparable<Media>{
    private String title;
    private String category;
    private float cost;
    private LocalDate dateAdded = LocalDate.now();
    private static int nbMedia = 0;
    private int id = nbMedia + 1;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getCategory() {
        return this.category;
    }
    public float getCost() {
        return this.cost;
    }
    public LocalDate getDateAdded() {
        return this.dateAdded;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public void setDateAdded(LocalDate date) {
        this.dateAdded = date;
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

    public boolean equals(Object obj) throws ClassCastException {
        if (obj instanceof Media) {
            try {
                Media obj2 = (Media) obj;
                if (obj2.getTitle() == this.title) {
                    return true;
                }
            } catch (ClassCastException e) {
                throw e;
            }
        }
        return false;
    }

    public int compareTo(Media obj) throws NullPointerException {
        try {
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
            for (int i = 0; i < this.category.length() && i < obj.getCategory().length(); i++) {
                if ((int) this.category.charAt(i) == (int) obj.getCategory().charAt(i)) {
                    continue;
                } else {
                    return ((int) this.category.charAt(i) - (int) obj.getTitle().charAt(i));
                }
            }
            if (!(this.category.length() == obj.getCategory().length())) {
                return (this.category.length() - obj.getCategory().length());
            }
            return 0;
        } catch (NullPointerException e) {
            throw e;
        }
    }


}

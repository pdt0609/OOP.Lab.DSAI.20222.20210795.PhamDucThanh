package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Objects;

public class Store {
    private static int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> dvdList() {
        return this.itemsInStore;
    }

    public void addMedia(Media media) {
        if (this.itemsInStore.size() < MAX_NUMBERS_ORDERED) {
            this.itemsInStore.add(media);
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        if (this.itemsInStore.contains(media)) {
            this.itemsInStore.remove(media);
            System.out.println("The media is removed");
        } else {
            System.out.println("The media is not existed in the store");
        }
    }

    public void print() {
        System.out.println();
        System.out.println("*******************STORE******************");
        System.out.println("Ordered Items:");
        if (this.itemsInStore.size() == 0) {
            System.out.println("Empty!!!");
        }
        for (int i = 0; i < this.itemsInStore.size(); i++) {
            if (!(Objects.equals(null, itemsInStore.get(i)))) {
                System.out.println(itemsInStore.get(i).toString());
            }
        }
        System.out.println("******************************************");
    }

	public ArrayList<Media> getItemsInStore() {
		// TODO Auto-generated method stub
		return this.itemsInStore;
	}
}

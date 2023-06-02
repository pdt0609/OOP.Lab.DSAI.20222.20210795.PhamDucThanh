package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc itemsInStore[]=new DigitalVideoDisc[100];
	private int ordered = 0;
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore[ordered] = disc;
		ordered += 1;

			System.out.println("The disc (" + disc.getTitle() + ", "
											+ disc.getCategory() + ", "
											+ disc.getDirector() + ", "
											+ disc.getLength() + ", "
											+ disc.getCost() + ") has been added");
		}
	public void removeDVD(DigitalVideoDisc disc) {
		for (int i = 0; i < ordered; i++) {
			if (disc.getCategory() == itemsInStore[i].getCategory() &&
					disc.getDirector() == itemsInStore[i].getDirector() &&
					disc.getTitle() == itemsInStore[i].getTitle() &&
					disc.getCost() == itemsInStore[i].getCost() &&
					disc.getLength() == itemsInStore[i].getLength()) {
				for (int j = i; j < ordered - 1; j++) {
					itemsInStore[j].setCategory(itemsInStore[j + 1].getCategory());
					itemsInStore[j].setDirector(itemsInStore[j + 1].getDirector());
					itemsInStore[j].setTitle(itemsInStore[j + 1].getTitle());
					itemsInStore[j].setCost(itemsInStore[j + 1].getCost());
					itemsInStore[j].setLength(itemsInStore[j + 1].getLength());
				}
				ordered -= 1;
				System.out.println("The disc (" + disc.getTitle() + ", "
												+ disc.getCategory() + ", "
												+ disc.getDirector() + ", "
												+ disc.getLength() + ", "
												+ disc.getCost() + ") has been removed");
			}
		}
	}

}
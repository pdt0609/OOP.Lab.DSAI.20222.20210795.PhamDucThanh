package Lab02;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc (" + disc.getTitle() + ", "
											+ disc.getCategory() + ", "
											+ disc.getDirector() + ", "
											+ disc.getLength() + ", "
											+ disc.getCost() + ") has been added");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (disc.getCategory() == itemsOrdered[i].getCategory() &&
					disc.getDirector() == itemsOrdered[i].getDirector() &&
					disc.getTitle() == itemsOrdered[i].getTitle() &&
					disc.getCost() == itemsOrdered[i].getCost() &&
					disc.getLength() == itemsOrdered[i].getLength()) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j].setCategory(itemsOrdered[j + 1].getCategory());
					itemsOrdered[j].setDirector(itemsOrdered[j + 1].getDirector());
					itemsOrdered[j].setTitle(itemsOrdered[j + 1].getTitle());
					itemsOrdered[j].setCost(itemsOrdered[j + 1].getCost());
					itemsOrdered[j].setLength(itemsOrdered[j + 1].getLength());
				}
				qtyOrdered -= 1;
				System.out.println("The disc (" + disc.getTitle() + ", "
												+ disc.getCategory() + ", "
												+ disc.getDirector() + ", "
												+ disc.getLength() + ", "
												+ disc.getCost() + ") has been removed");
			}
		}
	}
	public float totalCost() {
		float tCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			tCost += itemsOrdered[i].getCost();
		}
		return tCost;
	}


	
}

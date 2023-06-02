package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import hust.soict.dsai.test.TestPassingParameter;

public class Cart {
	public static final int MAX_LIMITED_ORDERS = 5;
	public static final int MAX_NUMBERS_ORDERED = 10;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public int nbMedias = 0;
	public int nbDVD=0;
	public int getNoDVD() {
		for (int i = 0; i < itemsOrdered.size(); i++)
			if (itemsOrdered.get(i).getCategory()=="DVD" ||itemsOrdered.get(i).getCategory()=="DigitalVideoDisc")
				nbDVD+=1;
		return nbDVD;
	}
	public ArrayList<Media> dvdList() {
        return this.itemsOrdered;
    }

	public void addMedia(Media med) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
		} else {
			itemsOrdered.add(med);
			System.out.println("The media (" + med.getTitle() + ", "
											+ med.getCategory() + ", "
											+ med.getCost() + ") has been added");
			nbMedias += 1;
		}
	}
	
	
	public void removeMedia(Media med) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (med.getCategory() == itemsOrdered.get(i).getCategory() &&
					med.getTitle() == itemsOrdered.get(i).getTitle() &&
					med.getCost() == itemsOrdered.get(i).getCost()) {
				for (int j = i; j < itemsOrdered.size() - 1; j++) {
					itemsOrdered.get(j).setCategory(itemsOrdered.get(j + 1).getCategory());
					itemsOrdered.get(j).setTitle(itemsOrdered.get(j + 1).getTitle());
					itemsOrdered.get(j).setCost(itemsOrdered.get(j + 1).getCost());
				}
				System.out.println("The media (" + med.getTitle() + ", "
												+ med.getCategory() + ", "
												+ med.getCost() + ") has been removed");
				nbMedias -= 1;
			} else {
				System.out.println("There is no media suited this!");
			}
		}
	}
	
	
	
	public float totalCost() {
		float tCost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			tCost += itemsOrdered.get(i).getCost();
		}
		return tCost;
	}

	    public void sortCost() {
	        for (int i = 0; i < this.itemsOrdered.size(); i++) {
	            for (int j = i + 1; j < this.itemsOrdered.size(); j++) {
	                if (this.itemsOrdered.get(i).getCost() < this.itemsOrdered.get(j).getCost()) {
	                    TestPassingParameter.swap(this.itemsOrdered.get(i), this.itemsOrdered.get(j));
	                }
	            }
	        }
	        System.out.println("Cart sorted by cost: " + itemsOrdered);
	    }

	    public void sortTitle() {
	        for (int i = 0; i < this.itemsOrdered.size(); i++) {
	            for (int j = i + 1; j < this.itemsOrdered.size(); j++) {
	                if (this.itemsOrdered.get(i).getTitle().compareTo(this.itemsOrdered.get(j).getTitle()) > 0) {
	                    TestPassingParameter.swap(this.itemsOrdered.get(i), this.itemsOrdered.get(j));
	                }
	            }
	        }
	        System.out.println("Cart sorted by title: " + itemsOrdered);
	    }

	    public void searchById(int[] idList) {
	        for (int i = 0; i < idList.length; i++) {
	            System.out.println(this.itemsOrdered.get(idList[i]).toString());
	        }
	    }

	    public void print() {
	        System.out.println();
	        System.out.println("*******************CART*******************");
	        System.out.println("Ordered Items:");
	        if (this.itemsOrdered.size() == 0) {
	            System.out.println("Empty!!!");
	        }
	        for (int i = 0; i < this.itemsOrdered.size(); i++) {
	            System.out.println(itemsOrdered.get(i).toString());
	        }
	        System.out.println("Total cost: " + this.totalCost());
	        System.out.println("******************************************");
	    }

	    public void searchByTitle(String title) {
	        for (int i = 0; i < this.itemsOrdered.size(); i++) {
	            if (this.itemsOrdered.get(i).isMatch(title)) {
	                System.out.println("The DVD needed is: ");
	                System.out.println(this.itemsOrdered.get(i).toString());
	                return;
	            }
	        }
	        System.out.println("There is no DVD matching...");
	    }
	    public ArrayList<Media> filterId(String str) {
	    	ArrayList<Media> viewFilter = new ArrayList<Media>();
	        for (int i = 0; i < this.itemsOrdered.size(); i++) {
	            if (str.length() > String.valueOf(this.itemsOrdered.get(i).getId()).length()) {
	                continue;
	            } else if (String.valueOf(this.itemsOrdered.get(i).getId()).substring(0, str.length()).equals(str)) {
	                viewFilter.add(this.itemsOrdered.get(i));
	            }
	        }
	        return viewFilter;
	    }

	    public ArrayList<Media> filterTitle(String str) {
	    	ArrayList<Media> viewFilter = new ArrayList<Media>();
	        for (int i = 0; i < this.itemsOrdered.size(); i++) {
	            if (str.length() > String.valueOf(this.itemsOrdered.get(i).getTitle()).length()) {
	                continue;
	            } else if (this.itemsOrdered.get(i).getTitle().substring(0, str.length()).equals(str)) {
	                viewFilter.add(this.itemsOrdered.get(i));
	            }
	        }
	        return viewFilter;
	    }

}

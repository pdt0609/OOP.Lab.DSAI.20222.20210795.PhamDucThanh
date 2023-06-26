package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import hust.soict.dsai.test.TestPassingParameter;
import javax.naming.LimitExceededException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
    private static int MAX_NUMBERS_ORDER = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private ObservableList<Media> viewFilter;

    public void addMedia(Media media) throws LimitExceededException {
        if (this.itemsOrdered.size() < MAX_NUMBERS_ORDER) {
            if (this.itemsOrdered.contains(media)) {
                System.out.println("The media existed in the list");
            } else {
                this.itemsOrdered.add(media);
                System.out.println("The media is added");
            }
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public void removeMedia(Media media) {
        if (this.itemsOrdered.contains(media)) {
            this.itemsOrdered.remove(media);
            System.out.println("The media is removed");
        } else {
            System.out.println("The media did not exist in the cart");
        }
    }
    public float totalCost() {
        float sumCost = 0;
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            sumCost += itemsOrdered.get(i).getCost();
        }
        return sumCost;
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

    public ObservableList<Media> dvdList() {
        return this.itemsOrdered;
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

    public Media getALuckyItem() {
        if (this.itemsOrdered.size() > 2) {
            int luckyNumber = (int)(Math.random() * this.itemsOrdered.size());
            return this.itemsOrdered.get(luckyNumber);
        } else {
            System.out.println("No lucky item!!!");
            return null;
        }
    }

    public ObservableList<Media> filterId(String str) {
        viewFilter = FXCollections.observableArrayList();
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (str.length() > String.valueOf(this.itemsOrdered.get(i).getId()).length()) {
                continue;
            } else if (String.valueOf(this.itemsOrdered.get(i).getId()).substring(0, str.length()).equals(str)) {
                viewFilter.add(this.itemsOrdered.get(i));
            }
        }
        return viewFilter;
    }

    public ObservableList<Media> filterTitle(String str) {
        viewFilter = FXCollections.observableArrayList();
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
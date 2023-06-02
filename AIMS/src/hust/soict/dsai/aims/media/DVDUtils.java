package hust.soict.dsai.aims.media;

import hust.soict.dsai.test.TestPassingParameter;

public class DVDUtils {
    public static String compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (dvd1.getCost() < dvd2.getCost()) {
            return "The cost of " + dvd1.toString() + " is smaller than the cost of " + dvd2.toString();
        } else if (dvd1.getCost() > dvd2.getCost()) {
            return "The cost of " + dvd1.toString() + " is bigger than the cost of " + dvd2.toString();
        } else {
            return "The cost of " + dvd1.toString() + " is equal to the cost of " + dvd2.toString();
        }
    };

    public static String compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)  {
        if (dvd1.getTitle().compareTo(dvd2.getTitle()) < 0) {
            return "The title of " + dvd1.getTitle() + " comes before " + dvd2.getTitle();
        } else if (dvd1.getTitle().compareTo(dvd2.getTitle()) > 0) {
            return "The title of " + dvd1.getTitle() + " comes after " + dvd2.getTitle();
        } else {
            return "The title of " + dvd1.getTitle() + " is the same as " + dvd2.getTitle();
        }
    };

    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc [] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            for (int j = i + 1; j < dvdList.length; j++) {
                if (dvdList[i].getCost() > dvdList[j].getCost()) {
                    TestPassingParameter.swap(dvdList[i], dvdList[j]);
                }
            }
        }
        return dvdList;
    };

    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc [] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            for (int j = i + 1; j < dvdList.length; j++) {
                if (dvdList[i].getTitle().compareTo(dvdList[j].getTitle()) > 0) {
                    TestPassingParameter.swap(dvdList[i], dvdList[j]);
                }
            }
        }
        return dvdList;
    };
}
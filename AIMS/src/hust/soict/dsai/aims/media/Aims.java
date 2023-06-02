package hust.soict.dsai.aims.media;
import java.util.Scanner;

import javax.naming.LimitExceededException;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner userInput = new Scanner(System.in);
        int i = 0;
        String Option;
        String title;
        String category = "";
        String director = "";
        int length = 0;
        float cost = 0;
        String author = "";
        String artist = "";
        String track_title = "";
        String content = "";
        int track_length = 0;
        int nb = 0;
        boolean status = true;
        ArrayList<String> list = new ArrayList<>();
        DigitalVideoDisc newDVD = new DigitalVideoDisc("", "", "", 0, 0);
        Book newBook = new Book("", "",list, 0,0);
        ArrayList<Track> tracks = new ArrayList<Track>();
        CompactDisc newCD = new CompactDisc("", "", "", "", tracks, 0);
        Media median;
        Collection<Media> collection;
        Iterator<Media> iterator;
        while (status) {
            if (i == 0) {
                showMenu();
                Option = userInput.nextLine();
                System.out.println("------------------------------------");
                if (Option.equals("1")) {
                    // Show all medias
                    store.print();
                    i += 1;
                    }
                else if (Option.equals("2")) {
                    // Update Store: Add or remove a Media from the store
                    System.out.println("Update: Add or remove?");
                    System.out.println("1. Add");
                    System.out.println("2. Remove");
                    System.out.print("Please choose a number: 1 - 2: => ");
                    Option = userInput.nextLine();
                    System.out.println("------------------------------------");
                    if (Option.equals("1")) {
                        System.out.println("Add something?");
                        System.out.println("1. DVD");
                        System.out.println("2. Book");
                        System.out.println("3. CD");
                        System.out.print("Please choose a number: 1 - 2 - 3: => ");
                        Option = userInput.nextLine();
                        System.out.println("------------------------------------");
                        if (Option.equals("1")) {
                            System.out.println("Add DVD to store:");
                            System.out.print("Title: ");
                            title = userInput.nextLine();
                            System.out.print("Category: ");
                            category = userInput.nextLine();
                            System.out.print("Director: ");
                            director = userInput.nextLine();
                            System.out.print("Length: ");
                            length = Integer.parseInt(userInput.nextLine());
                            System.out.print("Cost: ");
                            cost = Float.parseFloat(userInput.nextLine());
                            newDVD = new DigitalVideoDisc(title, category, director, length, cost);
                            store.addMedia(newDVD);
                            System.out.println("------------------------------------");
                        } else if (Option.equals("2")) {
                            System.out.println("Add book to store:");
                            System.out.print("Title: ");
                            title = userInput.nextLine();
                            System.out.print("Category: ");
                            category = userInput.nextLine();
                            System.out.print("The number of author: ");
                            nb = Integer.parseInt(userInput.nextLine());
                            list = new ArrayList<String>();
                            for (int k = 0; k < nb; k++) {
                                System.out.print("Author: ");
                                author = userInput.nextLine();
                                list.add(author);
                            }
                            System.out.print("Cost: ");
                            cost = Float.parseFloat(userInput.nextLine());
                            System.out.print("Content: ");
                            content = userInput.nextLine();
                            newBook = new Book(title, category, list, cost);
                            store.addMedia(newBook);
                            System.out.println("------------------------------------");
                        } else if (Option.equals("3")) {
                            System.out.println("Add CD to store:");
                            System.out.print("Title: ");
                            title = userInput.nextLine();
                            System.out.print("Category: ");
                            category = userInput.nextLine();
                            System.out.print("Artist: ");
                            artist = userInput.nextLine();
                            System.out.print("Director: ");
                            director = userInput.nextLine();
                            System.out.print("The number of Track: ");
                            nb = Integer.parseInt(userInput.nextLine());
                            tracks = new ArrayList<Track>();
                            for (int t = 0; t < nb; t++) {
                                System.out.print("Track " + (t+1) + " title: ");
                                track_title = userInput.nextLine();
                                System.out.print("Track " + (t+1) + " length: ");
                                track_length = Integer.parseInt(userInput.nextLine());
                                Track track = new Track(track_title, track_length);
                                tracks.add(track);
                            }
                            System.out.print("Cost: ");
                            cost = Float.parseFloat(userInput.nextLine());
                            newCD = new CompactDisc(title, category, artist, director, tracks, cost);
                            store.addMedia(newCD);
                            System.out.println("------------------------------------");
                        }
                    } else if (Option.equals("2")) {
                        System.out.print("The title of media removing from cart: ");
                        title = userInput.nextLine();
                        for (int j = store.dvdList().size()-1; j >= 0; j--) {
                            if (store.dvdList().get(j).isMatch(title)) {
                                median = store.dvdList().get(j);
                                System.out.println(median.toString());
                                System.out.println("------------------------------------");
                                System.out.println("Do you want to remove this media from the cart?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.print("Please choose a number: 1 - 2: => ");
                                Option = userInput.nextLine();
                                if (Option.equals("1")) {
                                    store.removeMedia(median);
                                }
                                System.out.println("------------------------------------");
                            }
                        }
                    }
/*... */              } else if (Option.equals("3")) {
                    // See current cart
                    cart.print();
                    i += 2;
                }
                else if (Option.equals("0")) {
                    status = false;
                }
            } else if (i == 1) {
                storeMenu();
                Option = userInput.nextLine();
                System.out.println("------------------------------------");
                if (Option.equals("1")) {
                    // Ask user enter the title of media
                    // Display the information of media
                    // The system allows the user to add that media in their cart
                    store.print();
                    System.out.print("The title of media shown: ");
                    title = userInput.nextLine();
                    System.out.println("------------------------------------");
                    System.out.println("Media's details:");
                    for (Media media : store.dvdList()) {
                        if (media.isMatch(title)) {
                            System.out.println(media.toString());
                            System.out.println("------------------------------------");
                            mediaDetailsMenu();
                            Option = userInput.nextLine();
                            
                            if (Option.equals("1")) {
                                cart.addMedia(media);
                            }else if(Option.equals("2")){
                            	if (media instanceof Playable) {
                            		System.out.println(media.toString());
                                    Playable media2 = (Playable) media;
                                    media2.play();
                                } else {
                                    System.out.println(media.toString());
                                    System.out.println("The media typed book can't play");
                                }
                            }else if(Option.equals("0")){
                            	i=1;
                            }
                            System.out.println("------------------------------------");
                        }
                    }
                } else if (Option.equals("2")) {
                    // Ask user enter the title of media
                    // Add the media to user's cart
                    // The system displays the number of medias in their cart
                    store.print();
                    System.out.print("The title of media added: ");
                    title = userInput.nextLine();
                    int count = 0;
                    for (Media media : store.dvdList()) {
                        if (media.isMatch(title)) {
                            count++;
                            cart.addMedia(media);
                            System.out.println("------------------------------------");
                             if (media.getCategory()=="DVD") {
                            	 cart.getNoDVD();
                            	 }
                        }
                    }
                    if (count==0) {
                        System.out.println("There's no media matched");
                        System.out.println("------------------------------------");
                    }
                } else if (Option.equals("3")) {
                	System.out.print("The title of media shown: ");
                    title = userInput.nextLine();
                    for (Media media : store.dvdList()) {
                        if (media.isMatch(title)) {
                            System.out.println(media.toString());
                            if (media instanceof Playable) {
                            	System.out.println(media.toString());
                                Playable media2 = (Playable) media;
                                media2.play();
                            } else {
                                System.out.println(media.toString());
                                System.out.println("The media typed book can't play");
                            }
                        }
                    }
                } else if (Option.equals("4")) {
                    // See current cart
                    cart.print();
                    i += 1;
                } else if (Option.equals("0")) {
                    i -= 1;
                }
            } else if (i == 2) {
                cartMenu();
                Option = userInput.nextLine();
                System.out.println("------------------------------------");
                if (Option.equals("1")) {
                    // Filter medias in the cart: two filtering options: by id or by title
                    System.out.println("Filter by id or title?");
                    System.out.println("1. id");
                    System.out.println("2. title");
                    System.out.print("Please choose a number: 1 - 2: => ");
                    Option = userInput.nextLine();
                    System.out.println("------------------------------------");
                    if (Option.equals("1")) {
                        System.out.print("Filter Id String: ");
                        Option = userInput.nextLine();
                        for (Media media: cart.filterId(Option)) {
                            System.out.println(media.toString());
                        }
                        System.out.println("------------------------------------");
                    } else if (Option.equals("2")) {
                        System.out.print("Filter Title String: ");
                        Option = userInput.nextLine();
                        for (Media media: cart.filterTitle(Option)) {
                            System.out.println(media.toString());
                        }
                        System.out.println("------------------------------------");
                    }    
                } else if (Option.equals("2")) {
                    // Sort medias in cart: by title or by cost
                    System.out.println("Sort by title or by cost?");
                    System.out.println("1. Title then Cost");
                    System.out.println("2. Cost then Title");
                    System.out.print("Please choose a number: 1 - 2: => ");
                    Option = userInput.nextLine();
                    System.out.println("------------------------------------");
                    if (Option.equals("1")) {
                        collection = new ArrayList<Media>();
                        for (Media media: cart.dvdList()) {
                            collection.add(media);                            
                        }
                        iterator = collection.iterator();
                        Collections.sort((List<Media>)collection, Media.COMPARE_BY_TITLE_COST);
                        iterator = collection.iterator();
                        System.out.println();
                        System.out.println("*******************CART*******************");
                        System.out.println("Ordered Items:");
                        if (cart.dvdList().size() == 0) {
                            System.out.println("Empty!!!");
                        }
                        while (iterator.hasNext()) {
                            System.out.println(((Media)iterator.next()).toString());
                        }
                        System.out.println("Total cost: " + cart.totalCost());
                        System.out.println("******************************************");
                    } else if (Option.equals("2")){
                        collection = new ArrayList<Media>();
                        for (Media media: cart.dvdList()) {
                            collection.add(media);                            
                        }
                        iterator = collection.iterator();
                        Collections.sort((List<Media>)collection, Media.COMPARE_BY_COST_TITLE);
                        iterator = collection.iterator();
                        System.out.println();
                        System.out.println("*******************CART*******************");
                        System.out.println("Ordered Items:");
                        if (cart.dvdList().size() == 0) {
                            System.out.println("Empty!!!");
                        }
                        while (iterator.hasNext()) {
                            System.out.println(((Media)iterator.next()).toString());
                        }
                        System.out.println("Total cost: " + cart.totalCost());
                        System.out.println("******************************************");
                    }
                } else if (Option.equals("3")) {
                    // Remove media from cart
                    System.out.print("The title of media removing from cart: ");
                    title = userInput.nextLine();

                    for (int j = cart.dvdList().size()-1; j >= 0; j--) {
                        if (cart.dvdList().get(j).isMatch(title)) {
                            median = cart.dvdList().get(j);
                            cart.removeMedia(median);
                            System.out.println("------------------------------------");
                        }
                    }
                } else if (Option.equals("4")) {
                	System.out.print("The title of media shown: ");
                    title = userInput.nextLine();
                    for (Media media : store.dvdList()) {
                        if (media.isMatch(title)) {
                            System.out.println(media.toString());
                            if (media instanceof Playable) {
                            	System.out.println(media.toString());
                                Playable media2 = (Playable) media;
                                media2.play();
                            } else {
                                System.out.println(media.toString());
                                System.out.println("The media typed book can't play");
                            }
                        }
                    }
                } else if (Option.equals("4")) {
                    // Place order
                    System.out.println("An order is created");
                    for (int j = cart.dvdList().size()-1; j >= 0; j--) {
                            median = cart.dvdList().get(j);
                            cart.removeMedia(median);
                    cart.print();
                }
                } else if (Option.equals("0")) {
                    i -= 1;
                }
            }
        }
        System.out.println("Goodbye forever!!!");
        userInput.close();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("------------------------------------");
        System.out.print("Please choose a number: 0 - 1 - 2 - 3: => ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. See current cart");
        System.out.println("0. Back");
        System.out.println("------------------------------------");
        System.out.print("Please choose a number: 0 - 1 - 2 - 3: => ");
    }
    public static void mediaDetailsMenu() {
    	System.out.println("Options: ");
    	System.out.println("--------------------------------");
    	System.out.println("1. Add to cart");
    	System.out.println("2. Play");
    	System.out.println("0. Back");
    	System.out.println("--------------------------------");
    	System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Place order");
        System.out.println("0. Back");
        System.out.println("------------------------------------");
        System.out.print("Please choose a number: 0 - 1 - 2 - 3 - 4: => ");
    }
}

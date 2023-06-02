package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private ArrayList<String> authors = new ArrayList<String>();
	private int length;
	public Book() {
		
	}
	
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category, float cost, int length) {
		super(title, category, cost);
		this.length = length;
	}
	public Book(String title, String category) {
		super(title, category);
	}
	public Book(String title, String category,  ArrayList<String> authors,float cost, int length) {
		super(title, category, cost);
		this.authors = authors;
		this.length = length;
	}
	public Book(String title, String category,  ArrayList<String> authors,float cost) {
		super(title, category, cost);
		this.authors = authors;
	}
	public Book(String title, String category, ArrayList<String> authors) {
		super(title, category);
		this.authors = authors;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			System.out.println("This author is already added!");
		} else {
			this.authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			this.authors.remove(authorName);
		} else {
			System.out.println("This author is not added!");
		}
	}
	public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.authors.toString() + " - " + this.getCost() + " - " ;
    }
}
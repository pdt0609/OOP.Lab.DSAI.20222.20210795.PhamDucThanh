package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Book extends Media {
    private ArrayList<String> authors; // = new ArrayList<String>();
    private String content;
    private List<String> contentTokens;
    private Map<String, Integer> wordFrequency;

    public Book(String title, String category,  ArrayList<String> authors, float cost) {
        setTitle(title);
        setCategory(category);
        this.authors = authors;
        setCost(cost);
    }

    public Book(String title, String category,  ArrayList<String> authors, float cost, String content) {
        setTitle(title);
        setCategory(category);
        this.authors = authors;
        setCost(cost);
        this.content=content;
        this.processContent();
    }
    public ArrayList<String> getAuthors() {
        return this.authors;   
    }
    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("The author is existed in the list of author");
        } else {
            this.authors.add(authorName);
            System.out.println("The author is added");
        }
    }

    public void removeAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            this.authors.remove(authorName);
            System.out.println("The author is removed");
        } else {
            System.out.println("The author is not existed in the list of author");
        }
    }

    /*public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.authors.toString();
    }*/

    public void processContent() {
        String[] tokens = content.split(" ");
        Arrays.sort(tokens);
        this.contentTokens = Arrays.asList(tokens);
        Map<String, Integer> map = new TreeMap<String, Integer>(Comparator.naturalOrder());
        for (String s : tokens) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        wordFrequency = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.authors.toString() + " - " + this.getCost() + " - " + this.content + " - " + this.content.split(" ").length + " - " + this.contentTokens.toString() + " - " + this.wordFrequency.toString();
    }
}

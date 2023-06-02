package hust.soict.dsai.aims.media;
import java.util.Comparator;
public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media media, Media media2) {
        return Comparator.comparing(Media::getTitle).thenComparing(Media::getCost).compare(media, media2);
    }
}
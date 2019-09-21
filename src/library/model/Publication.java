package library.model;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

// zmienienie klasy na klasa abstrakcyjną blokuje możliwość tworzenia obiektów tego typu
public abstract class Publication implements Serializable, Comparable<Publication>, CsvConvertible {

    private String title;
    private String publisher;
    private Year year;

    Publication(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = Year.of(year);
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getPublisher() {
        return publisher;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return title.equals(that.title) &&
                publisher.equals(that.publisher) &&
                year.equals(that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publisher, year);
    }

    @Override
    public String toString() {
        return title + ", " + publisher + ", " + year;
    }

    // nadpisuję metodę compareTo, aby sortowała po tytule
    @Override
    public int compareTo(Publication p){
        return title.compareToIgnoreCase(p.title);
    }
}

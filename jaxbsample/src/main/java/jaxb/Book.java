package jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

    private String author;

    private String title;

    private int year;

    private String isbn10;

    public Book() {
    }

    public Book(String author, String title, int year, String isbn10) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn10 = isbn10;
    }

    @XmlElement(name = "book-author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlAttribute
    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
}

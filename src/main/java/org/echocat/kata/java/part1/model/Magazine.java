package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.model.prototype.Publication;
import lombok.ToString;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Getter
@ToString
public class Magazine extends Publication {
    private Date publishedAt;

    // private default constructor for immutability
    private Magazine (){}

    public Magazine (String title, String isbn, List <Author> authors, Date publishedAt){
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.publishedAt = publishedAt;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getIsbn() {
        return this.isbn;
    }

    @Override
    public List<Author> getAuthors() {
        return this.authors;
    }

    public void printToConsole() {
        System.out.println("Type: Book");
        System.out.println("Title: " + title);
        System.out.println("Isbn: " + isbn);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy", Locale.GERMANY);
        System.out.println("Published: " + formatter.format(publishedAt));
    }
}

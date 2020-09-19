package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.model.prototype.Publication;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@ToString
public class Book extends Publication {
    private String description;

    // private default constructor for immutability
    private Book(){}

    public Book (String title, String isbn, List<Author> authors, String description){
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.description = description;
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
        System.out.println("Description: " + description);
    }
}

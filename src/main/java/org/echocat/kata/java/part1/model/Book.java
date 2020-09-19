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
}

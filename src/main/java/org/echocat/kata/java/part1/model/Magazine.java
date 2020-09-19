package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.model.prototype.Publication;
import lombok.ToString;
import lombok.Getter;
import java.util.Date;
import java.util.List;

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
}

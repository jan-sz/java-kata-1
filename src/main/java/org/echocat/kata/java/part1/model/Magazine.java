package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.model.prototype.Publication;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Magazine extends Publication {
    private Date publishedAt;

    // private default constructor for immutability
    private Magazine(){}
}

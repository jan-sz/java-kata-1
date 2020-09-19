package org.echocat.kata.java.part1.model;

import org.echocat.kata.java.part1.model.prototype.Publication;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Book extends Publication {
    private String decsription;

    // private default constructor for immutability
    private Book(){}
}

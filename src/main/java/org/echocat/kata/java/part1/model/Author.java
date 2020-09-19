package org.echocat.kata.java.part1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Author {
    private String email;
    private String firstname;
    private String lastname;

    // private default constructor for immutability
    private Author(){}
}

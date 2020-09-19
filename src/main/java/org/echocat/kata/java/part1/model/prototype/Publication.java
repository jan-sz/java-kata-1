package org.echocat.kata.java.part1.model.prototype;

import org.echocat.kata.java.part1.model.Author;
import java.util.List;

public abstract class Publication {
    protected String title;
    protected String isbn;
    protected List<Author> authors;
}

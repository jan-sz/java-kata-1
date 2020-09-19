package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.model.Book;
import java.util.List;

public interface BooksRepository {
    public List<Book> findAll();

}

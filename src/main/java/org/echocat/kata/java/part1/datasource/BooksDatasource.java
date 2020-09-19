package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.CSVReader.CSVReaderService;
import org.echocat.kata.java.part1.datasource.prototype.PublicationsDatasourceInterface;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksDatasource implements PublicationsDatasourceInterface {
    private List<Book> books;
    private String CSVFilePath = "books.csv";

    public BooksDatasource () {
        this.books = getBooksFromCSV();
    }

    private List<Book> getBooksFromCSV () {
        List<Book> booksFromCSV = new ArrayList<>();

        List<List<String>> listOfValues = CSVReaderService.readCSVFile(CSVFilePath);
        listOfValues.stream().forEach(values -> {
                                //title;     isbn;   authors;   description
            Book book = new Book(values.get(0), values.get(1), findAuthors(values.get(2)), values.get(3));
            booksFromCSV.add(book);
        });

        return booksFromCSV;
    }


    @Override
    protected List<Author> findAuthors(String authorsEmails) {
        return null;
    }
}

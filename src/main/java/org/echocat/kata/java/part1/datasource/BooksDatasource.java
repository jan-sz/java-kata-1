package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.util.CSVReaderService;
import org.echocat.kata.java.part1.datasource.util.PublicationsDatasourceHelper;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;

import java.util.ArrayList;
import java.util.List;

public class BooksDatasource extends PublicationsDatasourceHelper {
    private List<Book> books;
    private String CSVFilePath = "books.csv";

    public BooksDatasource () {
        this.books = getBooksFromCSV();
    }

    private List<Book> getBooksFromCSV () {
        List<Book> booksFromCSV = new ArrayList<>();

        List<List<String>> listOfValues = CSVReaderService.readCSVFile(CSVFilePath);
        listOfValues.stream().forEach(values -> {
            Book book = new Book(
                    values.get(0), // title;
                    values.get(1), // isbn;
                    findAuthors(values.get(2)), // authors;
                    values.get(3) // publishedAt;
            );
            booksFromCSV.add(book);
        });

        return booksFromCSV;
    }
}

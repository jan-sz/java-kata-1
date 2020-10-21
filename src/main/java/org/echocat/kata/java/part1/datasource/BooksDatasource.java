package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.util.CSVReaderService;
import org.echocat.kata.java.part1.datasource.util.PublicationsDatasourceHelper;
import org.echocat.kata.java.part1.model.Book;

import java.util.ArrayList;
import java.util.List;


public class BooksDatasource extends PublicationsDatasourceHelper {
    private List<Book> books;
    private String CSVFilePath = "books.csv";
    private static BooksDatasource booksDatasourceInstance;

    private BooksDatasource () {
        this.books = getBooksFromCSV();
    }

    public static BooksDatasource getInstance() {
        if (booksDatasourceInstance == null) {
            synchronized (BooksDatasource.class) {
                if (booksDatasourceInstance == null) {
                    booksDatasourceInstance = new BooksDatasource();
                }
            }
        }
        return booksDatasourceInstance;
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

    public List<Book> getAllBooks () {
        return books;
    }
}

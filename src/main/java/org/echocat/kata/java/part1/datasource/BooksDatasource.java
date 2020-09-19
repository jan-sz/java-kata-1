package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.util.CSVReaderService;
import org.echocat.kata.java.part1.datasource.util.PublicationsDatasourceHelper;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;

import java.util.ArrayList;
import java.util.List;

// I would prefer these Datasources to not be instance objects, but rather some overally available service
// like for example Spring Boot's beans, but I couldn't make this in time
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

    public List<Book> getAllBooks () {
        return books;
    }
}

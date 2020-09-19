package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.util.CSVReaderService;
import org.echocat.kata.java.part1.model.Author;

import java.util.ArrayList;
import java.util.List;

// I would prefer these Datasources to not be instance objects, but rather some overally available service
// like for example Spring Boot's beans, but I couldn't make this in time
public class AuthorsDatasource {
    private List<Author> authors;
    private String CSVFilePath = "authors.csv";

    public AuthorsDatasource () {
        this.authors = getAuthorsFromCSV();
    }

    private List<Author> getAuthorsFromCSV () {
        List<Author> authorsFromCSV = new ArrayList<>();

        List<List<String>> listOfValues = CSVReaderService.readCSVFile(CSVFilePath);
        listOfValues.stream().forEach(values -> {
            Author author = new Author(
                    values.get(0), // email
                    values.get(1), // firstname;
                    values.get(2)  // lastname
            );
            authorsFromCSV.add(author);
        });

        return authorsFromCSV;
    }

    public List<Author> getAllAuthors () {
        return authors;
    }
}

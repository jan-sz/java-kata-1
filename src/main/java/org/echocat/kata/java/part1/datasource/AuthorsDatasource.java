package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.util.CSVReaderService;
import org.echocat.kata.java.part1.model.Author;

import java.util.ArrayList;
import java.util.List;

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
}

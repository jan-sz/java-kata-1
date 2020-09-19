package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.CSVReader.CSVReaderService;
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
                                        //email;      firstname;     lastname
            Author author = new Author(values.get(0), values.get(1), values.get(2));
            authorsFromCSV.add(author);
        });

        return authorsFromCSV;
    }
}

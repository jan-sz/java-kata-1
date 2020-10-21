package org.echocat.kata.java.part1.datasource.util;

import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.repository.AuthorsRepository;
import org.echocat.kata.java.part1.repository.AuthorsRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class PublicationsDatasourceHelper {
    protected List<Author> findAuthors(String authorsEmails) {
        AuthorsRepository authorsRepository = new AuthorsRepositoryImpl();
        List<Author> authors = new ArrayList<>();
        String[] authorsEmailsSeparated = authorsEmails.split(",");

        for(String email : authorsEmailsSeparated) {
            authors.add(authorsRepository.findOneByEmail(email));
        }

        return authors;
    }
}

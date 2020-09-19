package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.datasource.AuthorsDatasource;
import org.echocat.kata.java.part1.datasource.PublicationsDatasource;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.prototype.Publication;

import java.util.List;

public class AuthorsRepositoryImpl implements AuthorsRepository{
    private AuthorsDatasource authorsDatasource;

    public AuthorsRepositoryImpl () {
        authorsDatasource = new AuthorsDatasource();
    }

    @Override
    public List<Author> findAll() {
        return authorsDatasource.getAllAuthors();
    }

    @Override
    public Author findOneByEmail(String email) {
        return authorsDatasource.getAllAuthors().stream().
                filter(
                        author -> author.getEmail().equals(email)
                )
                .findAny()
                .orElse(null);
    }
}

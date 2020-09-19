package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.datasource.PublicationsDatasource;
import org.echocat.kata.java.part1.model.prototype.Publication;

import java.util.List;

public class PublicationsRepositoryImpl implements PublicationsRepository {
    private PublicationsDatasource publicationsDatasource;

    public PublicationsRepositoryImpl () {
        publicationsDatasource = new PublicationsDatasource();
    }

    @Override
    public List<Publication> findAll() {
        return publicationsDatasource.getAllPublications();
    }

    @Override
    public Publication findOneByIsbn(String isbn) {
        return publicationsDatasource.getAllPublications().stream().
                filter(
                        publication -> publication.getIsbn().equals(isbn)
                )
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Publication> findAllByAuthorsEmail(String email) {
        return null;
    }
}

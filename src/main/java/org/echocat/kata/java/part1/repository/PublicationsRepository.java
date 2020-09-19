package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.model.prototype.Publication;

import java.util.List;

public interface PublicationsRepository {
    public List<Publication> findAll();
    public Publication findOneByIsbn(String isbn);
    public List<Publication> findAllByAuthorsEmail(String email);
}

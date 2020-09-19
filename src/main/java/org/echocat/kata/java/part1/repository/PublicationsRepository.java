package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.model.prototype.Publication;

import java.util.List;

public interface PublicationsRepository {
    public List<Publication> findAll();
    public List<Publication> findOneByIsbn();
    public List<Publication> findAllByAuthorsEmail();
}

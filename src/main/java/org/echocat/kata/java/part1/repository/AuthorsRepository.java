package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.model.prototype.Publication;

import java.util.List;

public interface AuthorsRepository {
    public List<Publication> findAll();
    public List<Publication> findOneEmail();
}

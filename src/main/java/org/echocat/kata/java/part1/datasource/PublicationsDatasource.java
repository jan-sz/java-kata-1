package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.prototype.Publication;

import java.util.ArrayList;
import java.util.List;

// I would prefer these Datasources to not be instance objects, but rather some overally available service
// like for example Spring Boot's beans, but I couldn't make this in time
public class PublicationsDatasource {
    private List<Publication> publications;
    private BooksDatasource booksDatasource;
    private MagazinesDatasource magazinesDatasource;

    public PublicationsDatasource () {
        this.publications = new ArrayList<>();
        this.magazinesDatasource = new MagazinesDatasource();
        this.booksDatasource = new BooksDatasource();

        publications.addAll(booksDatasource.getAllBooks());
        publications.addAll(magazinesDatasource.getAllMagazines());
    }

    public List<Publication> getAllPublications () {
        return publications;
    }
}

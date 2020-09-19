package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.repository.PublicationsRepository;
import org.echocat.kata.java.part1.repository.PublicationsRepositoryImpl;

public class MainApp {

    public static void main(String[] args) {
        PublicationsRepository publicationsRepository = new PublicationsRepositoryImpl();

        printAllPublications(publicationsRepository);
    }

    protected static void printAllPublications(PublicationsRepository publicationsRepository) {
        publicationsRepository.findAll().forEach(publication -> publication.printToConsole());
    };

    protected static String getHelloWorldText() {
        return "Hello world!";
    }
}

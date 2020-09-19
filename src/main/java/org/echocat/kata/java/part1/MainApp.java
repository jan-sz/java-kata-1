package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.repository.PublicationsRepository;
import org.echocat.kata.java.part1.repository.PublicationsRepositoryImpl;

public class MainApp {
    private static PublicationsRepository publicationsRepository;

    public static void main(String[] args) {
        publicationsRepository = new PublicationsRepositoryImpl();

    }
    private void printAllPublications() {

    };

    protected static String getHelloWorldText() {
        return "Hello world!";
    }
}

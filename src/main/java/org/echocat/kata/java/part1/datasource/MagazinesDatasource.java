package org.echocat.kata.java.part1.datasource;

import org.echocat.kata.java.part1.datasource.util.CSVReaderService;
import org.echocat.kata.java.part1.datasource.util.PublicationsDatasourceHelper;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.util.ApplicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// I would prefer these Datasources to not be instance objects, but rather some overally available service
// like for example Spring Boot's beans, but I couldn't make this in time
public class MagazinesDatasource extends PublicationsDatasourceHelper {
    private final Logger logger = LoggerFactory.getLogger(MagazinesDatasource.class);
    private List<Magazine> magazines;
    private String CSVFilePath = "magazines.csv";

    public MagazinesDatasource () {
        this.magazines = getMagazinesFromCSV();
    }

    private List<Magazine> getMagazinesFromCSV () {
        List<Magazine> magazinesFromCSV = new ArrayList<>();

        List<List<String>> listOfValues = CSVReaderService.readCSVFile(CSVFilePath);
        listOfValues.stream().forEach(values -> {
            Magazine magazine = new Magazine(
                    values.get(0), // title;
                    values.get(1), // isbn;
                    findAuthors(values.get(2)), // authors;
                    getDateFromString(values.get(3)) // publishedAt;
            );
            magazinesFromCSV.add(magazine);
        });

        return magazinesFromCSV;
    }

    private Date getDateFromString(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy", Locale.GERMANY);
        Date date = null;
        try {
            date= formatter.parse(dateString);
        } catch (Exception ex) {
            logger.error("There was an error with populating Magazines datasource", ex);
            ApplicationUtil.closeApplication();
        }
        return date;
    }

    public List<Magazine> getAllMagazines () {
        return magazines;
    }
}

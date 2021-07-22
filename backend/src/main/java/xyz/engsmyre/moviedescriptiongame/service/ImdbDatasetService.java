package xyz.engsmyre.moviedescriptiongame.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import xyz.engsmyre.moviedescriptiongame.domain.Rating;
import xyz.engsmyre.moviedescriptiongame.domain.Title;

@Service
public class ImdbDatasetService {

    public ImdbDatasetService() {

    }

     public Map<String, Title> getTitles() {
        try {
            URL titleURL = new URL("https://datasets.imdbws.com/title.basics.tsv.gz"); // TODO Move to resource file
            File tmpTitleFile = new File("/tmp/titles.csv");
            String[] titleHeaders = {"tconst", "titleType", "primaryTitle", "originalTitle"};
            Iterable<CSVRecord> titles = readCSVFile(titleURL, tmpTitleFile, titleHeaders);
            Map<String, Title> titleMap = new HashMap<>();
            for (CSVRecord title : titles) {
                String id = title.get("tconst");
                String primaryTitle = title.get("primaryTitle");
                String originalTitle = title.get("originalTitle");
                String type = title.get("titleType");
                Title t = new Title(id, primaryTitle, originalTitle, type);
                titleMap.put(t.getId(), t);
            }
            return titleMap;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to update ratings");
        }
        return null; // TODO Fix this
    }

    public  Map<String, Rating> getRatings() {
        try {
            URL ratingURL = new URL("https://datasets.imdbws.com/title.ratings.tsv.gz"); // TODO Move to resource file
            File tmpRating = new File("/tmp/ratings.csv");
            String[] ratingsHeaders = {"tconst", "averageRating", "numVotes"};
            Iterable<CSVRecord> ratings = readCSVFile(ratingURL, tmpRating, ratingsHeaders);
            Map<String, Rating> ratingMap = new HashMap<>();
            for (CSVRecord rating : ratings) {
                System.out.println(rating);
                String id = rating.get("tconst");
                double averageRating = Double.parseDouble(rating.get("averageRating"));
                int nVotes = Integer.parseInt(rating.get("numVotes"));
                Rating r = new Rating(id, averageRating, nVotes);
                ratingMap.put(r.getId(), r);
            }
            return ratingMap;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to update ratings");
        }
            return null; // TODO Fix this
}

    private Iterable<CSVRecord> readCSVFile(URL url, File tmpFile, String[] headers) throws IOException{
        FileUtils.copyURLToFile(url, tmpFile);
        xyz.engsmyre.moviedescriptiongame.util.FileUtils.decompressGzip(tmpFile);
        Reader ratingsIn = new FileReader(tmpFile);
        return CSVFormat.newFormat('\t')
                .withHeader(headers)
                .parse(ratingsIn);
    }
}

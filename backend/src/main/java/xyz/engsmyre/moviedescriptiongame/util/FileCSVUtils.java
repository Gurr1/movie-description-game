package xyz.engsmyre.moviedescriptiongame.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;

public class FileCSVUtils {
    public static Iterable<CSVRecord> readCSVFile(URL url, File tmpFile, String[] headers, String newName) throws IOException {
        FileUtils.copyURLToFile(url, tmpFile);
        FileCompressionUtils.decompressGzip(tmpFile, newName);
        Reader ratingsIn = new FileReader(newName);
        return CSVFormat.newFormat('\t')
                .withHeader(headers)
                .parse(ratingsIn);
    }
}

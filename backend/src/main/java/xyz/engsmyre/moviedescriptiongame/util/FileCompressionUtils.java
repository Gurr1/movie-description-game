package xyz.engsmyre.moviedescriptiongame.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class FileCompressionUtils {
    public static void decompressGzip(File file, String newName) throws IOException {
        try (GZIPInputStream gis = new GZIPInputStream(new FileInputStream(file)); FileOutputStream fos = new FileOutputStream(newName)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        }
    }
}

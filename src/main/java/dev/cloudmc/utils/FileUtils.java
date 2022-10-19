package dev.cloudmc.utils;

import java.io.*;
import java.net.URL;
public class FileUtils {

    public static void saveFile(String url, String fileName, String file) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(file + File.separator + fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

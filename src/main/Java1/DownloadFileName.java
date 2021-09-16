package main.Java1;
import main.util.HttpDownloadUtility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadFileName {
    public static void main(String[] args) throws IOException {
        String fileURL = "https://jdbc.postgresql.org/download/postgresql-42.2.23.jar";
        String saveDir = "C:\\Users\\billyy1\\Downloads";
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }
}

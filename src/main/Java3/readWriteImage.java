package main.Java3;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class readWriteImage {
    public static void main(String[] args) {
        URL url = null;

        BufferedImage image = null;

        try {
            url = new URL("https://www.google.ca/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }

        try {
            image = ImageIO.read(url);

            ImageIO.write(image, "jpg", new File("src/main/TESTRESULT/output.jpg"));

            ImageIO.write(image, "png", new File("src/main/TESTRESULT/output.png"));

            ImageIO.write(image, "gif", new File("src/main/TESTRESULT/output.gif"));

            ImageIO.write(image, "bmp", new File("src/main/TESTRESULT/output.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }
}
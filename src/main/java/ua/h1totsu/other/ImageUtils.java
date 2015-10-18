package ua.h1totsu.other;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageUtils {

    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    public static BufferedImage resizeImage(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        return resizedImage;
    }

    public static byte[] imageToBytes(BufferedImage image) {
        ByteArrayOutputStream outputStream = null;
        byte[] img = null;
        try {
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
            img = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static BufferedImage bytesToImage(byte[] img) {
        InputStream inputStream = new ByteArrayInputStream(img);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
}

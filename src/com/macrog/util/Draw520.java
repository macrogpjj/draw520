package com.macrog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author 67361
 * @date 2020/5/26 10:34
 */
public class Draw520 {

    private static final String FILL_TEXT = "我爱你";

    public static void main(String[] args) {
        Draw520.createFontImg("C:\\Users\\67361\\Desktop\\girl.jpg", "E:\\temp.jpg");
        System.out.println("OK");
    }


    private static void createFontImg(String sourcePath, String destinationPath) {

        try {
            BufferedImage image = ImageIO.read(new File(sourcePath));
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            graphics2D.setFont(new Font("宋体", Font.BOLD, 12));
            int index = 0;
            for (int y = 0; y < image.getHeight(); y += 12) {
                for (int x = 0; x < image.getWidth(); x += 12) {
                    int pxColor = image.getRGB(x, y);
                    int r = (pxColor & 0xff0000) >> 16,
                            g = (pxColor & 0xff00) >> 8,
                            b = pxColor & 0xff;
                    graphics2D.setColor(new Color(r, g, b));
                    graphics2D.drawString(String.valueOf(FILL_TEXT.charAt(index % FILL_TEXT.length())), x, y);
                    index++;
                }
            }
            ImageIO.write(newImage, "JPG", new FileOutputStream(destinationPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

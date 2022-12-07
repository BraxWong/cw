package com.Brax.Controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Controller_Image {
    /**
     * @Descripion
     * GetImage() will take the image path as an argument
     * If the image path and the image is found
     * It will return the image
     * Else the error will be caught
     */

    public static Image GetImage(String imagePath)
    {
        URL url = Controller_Leaderboard.class.getClassLoader().
                getResource(imagePath);
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(url);
        } catch (Exception e)
        {
            System.err.println("Images are not found \n");
            e.printStackTrace();
        }

        return image;
    }

    /**
     * @Description
     * Changing the variable to be more understandable.
     * Changed bufferedImaged to bf shortened the length of the code
     */
    public static Image RotateImage(final BufferedImage bufferedImage, final int degree)
    {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int transparency = bufferedImage.getColorModel().getTransparency();

        BufferedImage image;
        Graphics2D graphics2d;

        (graphics2d =
                (image = new BufferedImage(width, height, transparency)).
                        createGraphics())
                .setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        graphics2d.rotate(Math.toRadians(degree), width / 2, height / 2);
        graphics2d.drawImage(bufferedImage, 0, 0, null);
        graphics2d.dispose();

        return image;
    }
}

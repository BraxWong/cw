package com.Brax.Model;

import java.awt.*;
import java.util.Random;

public class Model_Food extends Model_MySnake {
    private final int TEN = 10;
    private final int MAX_X_PX = 550;
    private final int MAX_Y_PX = 300;
    private final int FIFTY = 50;

    /**
     * Food() constructor
     * Setting snake object class variables
     * super(x,y) will set the location of the snake
     * SetM_alive() will determine if the snake is alive or not
     * this.m_image will be the fruit image
     * SetM_width() and SetM_height() will set
     * where the fruit image will appear
     */
    public Model_Food()	{

        super(100,100);

        setM_alive(true);

        setM_image(Model_Images.m_images.get(String.valueOf(
                new Random().nextInt(TEN))));

        setM_width(getM_image().getWidth(null));

        setM_height(getM_image().getHeight(null));

        setM_x_Cord(new Random().nextInt(MAX_X_PX) + FIFTY);

        setM_y_Cord(new Random().nextInt(MAX_Y_PX) + FIFTY);
    }

    /**
     * eaten() checks if the snake has eaten itself
     * It will set the snake alive status to false,
     * Change the length of the snkae
     * Obtaining the score and increment it by 10.
     * @param modelMySnake
     * @return
     */

    public boolean eaten(Model_MySnake modelMySnake)	{

        if (modelMySnake.getRectangle().intersects(this.getRectangle()) &&
                getM_alive() && modelMySnake.getM_alive())	{

            setM_alive(false);

            modelMySnake.setM_length(modelMySnake.getM_length() + 1);

            int score = modelMySnake.getM_score();

            modelMySnake.setM_score(score+=TEN);

            return true;
        }
        return false;

    }

    /**
     * draw() puts the fruit image to the playing field
     * @param g
     */
    @Override
    public void draw(Graphics g) {

        g.drawImage(getM_image(), getM_x_Cord(), getM_y_Cord(), null);

    }
}

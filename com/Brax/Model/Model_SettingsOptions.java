package com.Brax.Model;

import com.Brax.Test.ModelSettingsOptions_setM_backgroundIMG_Test;
import com.Brax.Test.ModelSettingsOptions_setM_name_Test;
import com.Brax.Test.ModelSettingsOptions_setM_snakeHeadIMG_Test;
import com.Brax.Test.ModelSettingsOptions_setSpeed_Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import java.awt.image.BufferedImage;

public class Model_SettingsOptions {
    /**
     * getSpeed() returns the movement speed of the snake
     * @return
     */
    public static int getSpeed() {return m_speed; }

    /**
     * setSpeed() takes in the speed as an argument,
     * check it with a JUnit class to see if it is either
     * 5, 10, or 15.
     * Then it will set m_speed with the argument value
     * @param speed
     */
    public static void setSpeed(int speed) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        m_speed = speed;
        junit.run(ModelSettingsOptions_setSpeed_Test.class);
    }

    /**
     * getM_backgroundImg() returns the current value of m_backgroundImg,
     * which determines which background image to use for the game.
     * @return m_backgroundImg
     */
    public static int getM_backgroundImg() {
        return m_backgroundImg;
    }

    /**
     * setM-backgroundImg() takes an int as argument,
     * check it with a JUnit class to see if it is either
     * 1, 2, or 3.
     * Then it will set m_backgroundImg with the argument value
     * @param backgroundImgInt
     */
    public static void setM_backgroundImg(int backgroundImgInt) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        m_backgroundImg = backgroundImgInt;
        junit.run(ModelSettingsOptions_setM_backgroundIMG_Test.class);
    }

    /**
     * getSnakeHead() returns a BufferedImage object,
     * after checking getting the integer from snakeHeadImg using
     * getM_snakeHeadImg.
     * If getM_snakeHeadImg is 1, it will use m_images.get method within
     * Model_Images class to get the appropriate image.
     * If it returns 2, it will get a variation of the snake head image.
     * @return BufferedImage
     */

    public static BufferedImage getSnakeHead() {
        if(getM_snakeHeadImg() == 1){
            return (BufferedImage) Model_Images.m_images.
                    get("snake-head-right");
        }
        return (BufferedImage) Model_Images.m_images.get("snake-head-right2");
    }

    /**
     * getM_snakeHeadImg() returns the current value of m_snakeHeadImg
     * @return m_snakeHeadImg
     */

    public static int getM_snakeHeadImg() {
        return m_snakeHeadImg;
    }

    /**
     * setM_snakeHeadImg() takes an int as argument,
     * check it with a JUnit class to see if it is either
     * 1 or 2.
     * Then it will set m_snakeHeadImg with the argument value
     * @param snakeHeadImgInt
     */
    public static void setM_snakeHeadImg(int snakeHeadImgInt) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        m_snakeHeadImg = snakeHeadImgInt;
        junit.run(ModelSettingsOptions_setM_snakeHeadIMG_Test.class);
    }

    /**
     * getM_name() returns the current value of m_name,
     * which represents the player's name.
     * @return m_name
     */

    public static String getM_name() { return m_name; }

    /**
     * setM_name() takes a String as argument,
     * check it with a JUnit class to see if the length of the argument
     * is not NULL, then it will set m_name with the argument value
     * @param m_name
     */

    public static void setM_name(String m_name) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        Model_SettingsOptions.m_name = m_name;
        junit.run(ModelSettingsOptions_setM_name_Test.class);
    }

    private static int m_backgroundImg = 1;

    private static int m_snakeHeadImg = 1;

    private static int m_speed;

    private static String m_name;

}

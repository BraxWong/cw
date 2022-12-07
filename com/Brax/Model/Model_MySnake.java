package com.Brax.Model;

import com.Brax.Controller.Controller_Image;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import static com.Brax.Model.Model_SettingsOptions.getSnakeHead;


public class Model_MySnake extends Model_SnakeObject {




    /**
     * SetM_newImgSnakeHead() takes a BufferedImage object as argument,
     * then sets m_newImgSnakeHead to have the argument's value
     * @param image
     */

    public void setM_newImgSnakeHead(BufferedImage image){this.m_newImgSnakeHead = image;}

    /**
     * SetM_speed_XY() takes an int as argument,
     * then sets m_speed_XY to have the argument's value
     * @param speed_xy
     */

    public void setM_speed_XY(int speed_xy){this.m_speed_XY = speed_xy;}

    /**
     * ChangeM_length() takes an int as argument,
     * then sets m_length to have the argument's value
     * @param length
     */

    public void setM_length(int length){this.m_length = length;}

    /**
     * SetM_num() takes an int as argument,
     * then sets m_num to have the argument's value
     * @param num
     */

    public void setM_num(int num){this.m_num = num;}

    /**
     * SetM_score() takes an int as argument,
     * then sets m_score to have the argument's value
     * @param score
     */

    public void setM_score(int score){this.m_score = score;}

    /**
     * GetM_score() returns the current value of m_score
     * @return
     */

    public int getM_score(){return m_score;}

    /**
     * GetM_length() returns the current value of m_length
     * @return
     */
    public int getM_length() {return m_length;}
    private static final int FRAME_WIDTH = 785;
    private static final int FRAME_HEIGHT = 455;
    private static final int FENCE_WIDTH = 67;
    private static final int FENCE_HEIGHT = 57;
    private static final int NINETY = 90;
    private static final int NEG_NINETY = -90;
    private static final int NEG_ONE_EIGHTY = -180;
    private int m_speed_XY;
    private int m_length;
    private int m_num;
    private int m_score = 0;
    private static BufferedImage m_IMG_SNAKE_HEAD = getSnakeHead();
    public static List<Point> m_bodyPoints = new LinkedList<>();
    private static BufferedImage m_newImgSnakeHead;
    boolean m_up, m_down, m_left, m_right = true;

    /**
     * Model_MySnake constructor takes two int as arguments,
     * sets m_alive as true, m_x_cord and m_y_cord to the arguments,
     * setM_image() to set the body of the snake using m_images to get the
     * appropriate image.
     * Sets the width and height of the image as null for the observer.
     * Sets the speed of the snake using SetM_speed_XY().
     * Sets the length of the snake using ChangeM_length().
     * Sets m_num using SetM_num().
     * Sets the image of the snake head using SetM_newImgSnakeHead().
     * @param x
     * @param y
     */

    public Model_MySnake(int x, int y)
    {
        setM_alive(true);

        setM_x_Cord(x);

        setM_y_Cord(y);

        setM_image(Model_Images.m_images.get("snake-body"));

        setM_width(getM_image().getWidth(null));

        setM_height(getM_image().getHeight(null));

        setM_speed_XY(Model_SettingsOptions.getSpeed());

        setM_length(1);

        setM_num(getM_width() / Model_SettingsOptions.getSpeed());

        setM_newImgSnakeHead(m_IMG_SNAKE_HEAD);

    }

    /**
     * keyPressed dictates the direction of where the snake head points.
     * If the user pressed up, it will rotate m_IMG_SNAKE_HEAD -90 degrees,
     * If the user pressed down, it will rotate m_IMG_SNAKE_HEAD 90 degrees,
     * If the user pressed left, it will rotate m_IMG_SNAKE_HEAD -180 degrees,
     * If the user pressed right, m_IMG_SNAKE_HEAD will not be rotated.
     * @param e
     */
    public void keyPressed(KeyEvent e)
    {

        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (!m_down)
                {
                    m_up = true;
                    m_down = false;
                    m_left = false;
                    m_right = false;
                    setM_newImgSnakeHead((BufferedImage) Controller_Image.
                            RotateImage(m_IMG_SNAKE_HEAD, NEG_NINETY));
                }
                break;

            case KeyEvent.VK_DOWN:
                if (!m_up)
                {
                    m_up = false;
                    m_down = true;
                    m_left = false;
                    m_right = false;
                    setM_newImgSnakeHead((BufferedImage) Controller_Image.
                            RotateImage(m_IMG_SNAKE_HEAD, NINETY));
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!m_right)
                {
                    m_up = false;
                    m_down = false;
                    m_left = true;
                    m_right = false;
                    setM_newImgSnakeHead((BufferedImage) Controller_Image.
                            RotateImage(m_IMG_SNAKE_HEAD, NEG_ONE_EIGHTY));

                }
                break;

            case KeyEvent.VK_RIGHT:
                if (!m_left)
                {
                    m_up = false;
                    m_down = false;
                    m_left = false;
                    m_right = true;
                    setM_newImgSnakeHead(m_IMG_SNAKE_HEAD);
                }
            default:
                break;
        }
    }

    /**
     * move()
     * If it is m_up, it will get the current,
     * m_y_cord and subtract the speed of the snake,
     * then store it back to m_y_cord.
     * If it is m_down, it will get the current,
     * m_y_cord and increase the speed of the snake,
     * then store it back to m_y_cord.
     * If it is m_left, it will get the current,
     * m_x_cord and decrease the speed of the snake,
     * then store it back to m_x_cord.
     * If it is m_right, it will get the current,
     * m_x_cord and increase the speed of the snake,
     * then store it back to m_x_cord.
     */
    public void move()
    {

        if (m_up)
        {
            setM_y_Cord(getM_y_Cord()-m_speed_XY);
        } else if (m_down)
        {
            setM_y_Cord(getM_y_Cord()+m_speed_XY);
        } else if (m_left)
        {
            setM_x_Cord(getM_x_Cord()-m_speed_XY);
        } else if (m_right)
        {
            setM_x_Cord(getM_x_Cord()+m_speed_XY);
        }
    }

    /**
     * draw() takes a Graphics object as argument,
     * it will first call outOfBounds() to check if the snake is out of bound,
     * then it will call eatBody() to check if the snake is eating itself,
     * then it will add to m_bodyPoints according x_cord and y_cord.
     * the first index of m_bodyPoints will be removed if the size of the list,
     * is equal to the size of the snake + 1 and multiply by m_num.
     * If it is not equal,
     * it will call drawImage() method within Graphics class to draw
     * the snakeHead with m_newImgSnakeHead at x,y_cord.
     * It will call drawBody() by passing in a Graphics object to
     * draw the body.
     * It will then call move()
     * @param g
     */
    @Override
    public void draw(Graphics g)
    {
        outOfBounds();
        eatBody();
        m_bodyPoints.add(new Point(getM_x_Cord(), getM_y_Cord()));
        if (m_bodyPoints.size() == (getM_length() + 1) * m_num)
        {
            m_bodyPoints.remove(0);
        }
        g.drawImage(m_newImgSnakeHead, getM_x_Cord(), getM_y_Cord(), null);
        drawBody(g);
        move();
    }


    /**
     * eatBody() checks if the snake head is making contact with its
     * body by running two for loops on the m_bodyPoints list and
     * check the two pointers are equal to each other.
     * If they are equal, it will set M_alive to false.
     * If they are not equal, it will end the method if it
     * is not able to find a match after running the entire
     * list.
     */

    public void eatBody()
    {
        for (Point point : m_bodyPoints)
        {
            for (Point point2 : m_bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                    setM_alive(false);
                }
            }
        }
    }

    /**
     * drawBody() takes a Graphics object as argument.
     * It will store the result of the size of m_bodyPoints list
     * subtracted with 1 and m_num to length.
     * Then running a for loop to draw the snake body
     * @param g
     */

    public void drawBody(Graphics g)
    {
        int length = m_bodyPoints.size() - 1 - m_num;
        for (int i = length; i >= m_num; i -= m_num)
        {
            Point point = m_bodyPoints.get(i);
            g.drawImage(getM_image(), point.x, point.y, null);
        }
    }

    /**
     * outOfBounds() checks if the snake is out of bounds.
     * It will check the current x_cord with the FENCE_WIDTH and
     * y_cord with the FENCE_HEIGHT.
     * If one of them come back true, it is out of bound,
     * which will set m_alive to false.
     */

    private void outOfBounds()
    {

        boolean xOut = (getM_x_Cord() <= FENCE_WIDTH || getM_x_Cord() >= FRAME_WIDTH);
        boolean yOut = (getM_y_Cord() <= FENCE_HEIGHT || getM_y_Cord() >= FRAME_HEIGHT);
        if (xOut || yOut)
        {
            setM_alive(false);
        }
    }
}


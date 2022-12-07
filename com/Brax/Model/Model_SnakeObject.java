package com.Brax.Model;

import java.awt.*;

public abstract class Model_SnakeObject {

    /**
     * setM_alive() takes a boolean as argument,
     * then sets m_alive to the argument's value
     * @param m_alive
     */

    public void setM_alive(boolean m_alive){this.m_alive = m_alive;}

    /**
     * setM_width() takes an int as argument,
     * then sets m_width to the argument's value
     * @param m_width
     */
    public void setM_width(int m_width){this.m_width = m_width;}

    /**
     * setM_height() takes an int as argument,
     * then sets m_height to the argument's value
     * @param m_height
     */
    public void setM_height(int m_height){this.m_height = m_height;}

    /**
     * setM_x_Cord() takes an int as argument,
     * then sets m_x_Cord to the argument's value
     * @param m_x_Cord
     */
    public void setM_x_Cord(int m_x_Cord){this.m_x_Cord = m_x_Cord;}

    /**
     * setM_y_Cord() takes an int as argument,
     * then sets m_y_Cord to the argument's value
     * @param m_y_Cord
     */

    public void setM_y_Cord(int m_y_Cord){this.m_y_Cord = m_y_Cord;}

    /**
     * getM_x_Cord() returns the current value of m_x_Cord
     * @return m_x_Cord
     */

    public int getM_x_Cord(){return m_x_Cord;}

    /**
     * getM_y_Cord() returns the current value of m_y_Cord
     * @return m_y_Cord
     */
    public int getM_y_Cord(){return m_y_Cord;}

    /**
     * getM_width() returns the current value of m_width
     * @return m_width
     */

    public int getM_width(){return m_width;}

    /**
     * getM_alive() returns the current value of m_alive
     * @return m_alive
     */

    public boolean getM_alive(){return m_alive;}

    /**
     * getM_image() returns the current image of m_image
     * @return m_image
     */

    public Image getM_image() {return m_image;}

    /**
     * setM_image() takes an Image object as argument,
     * then sets m_image to the argument's value
     * @param m_image
     */

    public void setM_image(Image m_image) {this.m_image = m_image;}

    /**
     * getRectangle() creates a new Rectangle object with m_x_Cord,
     * m_y_Cord, m_width, and m_height as parameters.
     * Then return the newly created Rectangle object
     * @return Rectangle Object
     */
    public Rectangle getRectangle() {
        return new Rectangle(m_x_Cord, m_y_Cord, m_width, m_height);
    }

    private int m_x_Cord;

    private int m_y_Cord;

    Image m_image;

    private int m_width;

    private int m_height;

    private boolean m_alive;

    public abstract void draw(Graphics g);
}


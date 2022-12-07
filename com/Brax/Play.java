package com.Brax;

import com.Brax.Controller.Controller_FileSystem;
import com.Brax.Model.*;
import com.Brax.View.View_MyFrame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class Play extends View_MyFrame
{

    /**
     * Constructor for Play class
     * It is called from Controller_Levels when the play button is pressed
     * Then it will retrieve relevant information from SettingsOptions class
     * ie background IMG and player's name before the game begins
     */

    public Play(){

        if(Model_SettingsOptions.getM_backgroundImg() == 1){

            setM_background("UI-background");

        }

        else if(Model_SettingsOptions.getM_backgroundImg() == 2){

            setM_background("UI-background2");

        }

        else {

            setM_background("UI-background3");

        }

        setM_playerName(Model_SettingsOptions.getM_name());

        setM_mySnake(new Model_MySnake(100,100));

    }

    /**
     * setM_mySnake takes a MySnake object as argument,
     * then set m_mySnake to this.m_mySnake.
     * This is used within the constructor
     * @param m_Model_mySnake
     */

    public void setM_mySnake(Model_MySnake m_Model_mySnake) {
        this.m_Model_mySnake = m_Model_mySnake;
    }

    /**
     * getM_mySnake returns m_mySnake,
     * which is a MySnake object
     * @return
     */

    public Model_MySnake getM_mySnake() {
        return m_Model_mySnake;
    }

    /**
     * getM_background() returns the background image
     */

    public Image getM_background(){return m_background;}

    /**
     * setM_background takes a String variable as argument
     * then retrieve the image based on the String from the Model class
     * then sets it to m_background
     * @param str
     */

    public void setM_background(String str){this.m_background = Model_Images.m_images.get(str);}

    /**
     * getPlayerName() returns the name of the player
     * @return
     */

    public String getM_playerName() {return m_playerName;}

    /**
     * setPlayerName() takes a String variable as argument
     * and sets it to the playerName
     * @param name
     */

    public void setM_playerName(String name){this.m_playerName = name;}

    /**
     * Creates a MySnake object and sets its location at 100,100
     * (x,y coordinates)
     */

    public Model_MySnake m_Model_mySnake = new Model_MySnake(100,100);

    /**
     * Creates a Food object
     */

    public Model_Food m_Model_food = new Model_Food();
    private Image m_background,

    /**
     * Storing all fence related images for later use
     */

    m_FenceUp = Model_Images.m_images.get("Fence"),

    m_FenceLeft = Model_Images.m_images.get("Fence_Left"),

    m_FenceRight = Model_Images.m_images.get("Fence_Right");

    /**
     * num is used to make sure the csv file will not append
     * more than 1 time after the game has ended
     */
    public int m_num = 0;
    private final int TOP_X = 355;

    private final int ABS_X_CENTER = 300;

    private final int ABS_Y_CENTER = 330;

    private final int TOP_Y = 40;
    private final int SIZE_OF_FONT = 30;

    private final int MAX_X_AXIS = 870;

    private final int MAX_Y_AXIS = 485;

    private final int FENCE_WIDTH = 58;
    private final int FENCE_HEIGHT = 57;
    private final int FRAME_X = 812;
    private final int FRAME_Y = 480;
    private String m_playerName;

    @Override
    public void keyPressed(KeyEvent e)
    {

        super.keyPressed(e);

        m_Model_mySnake.keyPressed(e);

    }

    /**
     * This is called when Play.load() is called.
     * It will paint the background IMG, food IMG, and the fences
     * around the borders.
     * If the snake is dead, the program will display the endScreen,
     * then redraw the score and place it in the center of the screen.
     * It will create a FileSystem object so the program can append the
     * player name and the final score to record.csv file for the leaderboard.
     * If the snake is alive, the program will redraw the score string after
     * adding 10 points to the current score then display it on the screen
     * @param g  the <code>Graphics</code> context in which to paint
     */

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(m_background, 0, 0, null);
        for(int i = 0; i < MAX_X_AXIS; i += FENCE_WIDTH){
            g.drawImage(m_FenceUp,i,0,null);
            g.drawImage(m_FenceUp,i,FRAME_Y,null);
        }
        for(int i = FENCE_HEIGHT; i < MAX_Y_AXIS; i += FENCE_HEIGHT){
            g.drawImage(m_FenceLeft,0,i,null);
            g.drawImage(m_FenceRight,FRAME_X,i,null);
        }
        if (m_Model_mySnake.getM_alive()) {
            m_Model_mySnake.draw(g);
            if (m_Model_food.getM_alive()) {
                m_Model_food.draw(g);
                m_Model_food.eaten(m_Model_mySnake);
            } else {
                m_Model_food = new Model_Food();
            }
        } else {
            g.drawImage(Model_Images.m_images.get("game-scene-01"), 0, 0,
                    null);
            drawScore(g, true);
            if (m_num == 0) {

                Controller_FileSystem fs = new Controller_FileSystem();
                try {
                   fs.createScoreFile(getM_playerName(),
                            m_Model_mySnake.getM_score());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ++m_num;
            }
            return;
        }
            drawScore(g, false);
    }

    /**
     * drawScore() takes a Graphics and boolean as arguments.
     * boolean dead determines whether where the score will be drawn
     * on the screen.
     * If the snake is dead, it will retrieve the score using GetM_score(),
     * then display it at the center of the screen
     * If the snake is alive, it will retrieve the score using GetM_score(),
     * then display at the center in terms of x-axis
     * @param g
     * @param dead
     */

    public void drawScore(Graphics g, boolean dead)
    {

        int score = m_Model_mySnake.getM_score();

        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, SIZE_OF_FONT));

        g.setColor(Color.MAGENTA);

        if(!dead){

            g.drawString("SCORE : " + score, TOP_X, TOP_Y);

            return;

        }

        g.drawString("FINAL SCORE : " + score, ABS_X_CENTER, ABS_Y_CENTER );

    }

}



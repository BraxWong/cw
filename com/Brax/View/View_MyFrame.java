package com.Brax.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @Project Snakee
 * @Description Hladdu leikinn og endurnýjaðu hann stöðugt
 * @Author Sigurður Sigurðardóttir
 * @version Ekki viss
 */

public class View_MyFrame extends JPanel implements KeyListener {

    private final int FRAME_X = 870;
    private final int FRAME_Y = 560;

    public static JFrame m_jFrame = new JFrame();

    /**
     * Sets the icon of the frame by getting the snake logo image
     * from View_MyFrame class
     * @FIXME
     * snake-logo shouldn't be in View package,
     * but it won't work unless it is
     */
    public View_MyFrame() {
        m_jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(View_MyFrame.class.getResource("snake-logo.png")));
    }

    /**
     * loadFrame() sets the title, frame's size,
     * frame's location, resizeable, and visibility.
     * Then it will start the thread and display JSwing frame
     * to the screen.
     * @return
     */
    public boolean loadFrame() {

        this.setDoubleBuffered(true);
        m_jFrame.add(this);
        m_jFrame.addKeyListener(this);
        m_jFrame.setTitle("Snake Game");
        m_jFrame.setSize(FRAME_X, FRAME_Y);
        m_jFrame.setLocationRelativeTo(null);
        m_jFrame.setResizable(false);
        m_jFrame.setVisible(true);
        new MyThread().start();
        return true;

    }

    /**
     * Tune down sleep from 30 to 20 ms
     * to improve FPS
     */

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                repaint();
                try {
                    sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

}




package com.Brax.Controller;

import com.Brax.Model.Model_MusicPlayer;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Controller_MusicPlayer {

    /**
     * play() will create a Model_MusicPlayer object.
     * It will try to set musicPlayer.m_player by creating a Player object
     * within it, and passing in the file path by using getM_filename() method
     * within the Model_MusicPlayer class.
     * Then it will try to run the play() method within the Player class by
     * getting the Player object within Model_MusicPlayer by calling
     * getM_player().
     * If all is well, it will call start() method within the Thread class,
     * else it will print out the exception message
     */

        public void play() {
            Model_MusicPlayer musicPlayer = new Model_MusicPlayer();
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        musicPlayer.setM_player(new Player(new BufferedInputStream(new FileInputStream(musicPlayer.getM_filename()))));
                        musicPlayer.getM_player().play();

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }.start();
        }
}


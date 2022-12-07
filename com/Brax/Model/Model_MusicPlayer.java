package com.Brax.Model;

import javazoom.jl.player.Player;

public class Model_MusicPlayer {
    /**
     * setM_player() takes a Player object as argument,
     * then sets m_player to the argument's value
     * @param player
     */

    public void setM_player(Player player) {this.m_player = player;}

    /**
     * getM_player() returns the current value of m_player
     * @return m_player
     */

    public Player getM_player() {
        return m_player;
    }

    /**
     * getM_filename() returns the current value of m_filename
     * @return m_filename
     */

    public String getM_filename() {
        return m_filename;
    }

    private String m_filename = "src/com/Brax/misc/frogger.mp3";
    private Player m_player;
}

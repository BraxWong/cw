package com.Brax.Model;

public class Model_LeaderboardEntry {

    /**
     * setM_playerName() takes a String variable as argument,
     * then sets it to m_playerName
     * @param name
     */

    public void setM_playerName(String name) {this.m_playerName = name;}

    /**
     * getM_playerName() returns the current value of m_playerName
     * @return
     */

    public String getM_playerName() {return m_playerName;}

    /**
     * setM_score() takes an int variable as argument,
     * then sets it to m_score
     * @param score
     */

    public void setM_score(int score){this.m_score = score;}

    /**
     * getM_score() returns the current value of m_score
     * @return
     */

    public int getM_score() {return m_score;}

    /**
     * The constructor takes a String and an int variable as arguments,
     * then using setM_playerName(String var) and setM_score(int var)
     * to set the data
     * @param name
     * @param score
     */

    public Model_LeaderboardEntry(String name, int score) {

        setM_playerName(name);

        setM_score(score);

    }

    private String m_playerName;
    private int m_score;

}

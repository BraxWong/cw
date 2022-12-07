package com.Brax.Model;

public enum Model_Scenes {

    /**
     * Each Enum contains a filePath that stores the corresponding
     * FXML file
     */

    Menu("FXMLsb/MenuScreen.fxml"),
    Settings("FXMLsb/SettingsScreen.fxml"),
    Leaderboard("FXMLsb/LeaderboardScreen.fxml"),
    Level("FXMLsb/LevelScreen.fxml");

    private String m_filePath;

    /**
     * The constructor takes a String variable as argument,
     * then sets the argument to the filePath
     * @param filePath
     */

    Model_Scenes(String filePath){
        this.m_filePath = filePath;
    }

    /**
     * getFilePath() returns the current value of the filePath
     * @return
     */

    public String getFilePath() {return m_filePath;}
}

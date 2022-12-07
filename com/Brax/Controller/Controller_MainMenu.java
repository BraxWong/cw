package com.Brax.Controller;

import com.Brax.Model.Model_Scenes;
import com.Brax.Model.Model_SettingsOptions;
import com.Brax.SceneControl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller_MainMenu {
    /**
     *(Menu Screen)
     *m_Tips, and m_Name belong to the menu screen
     */
    @FXML
    private Label m_Tips;

    @FXML
    private TextField m_Name;

    /**
     * @Description:
     * levelSelection() will be called when the play button is clicked.
     * It will check if the name field has been used,
     * if not: the m_Tips label will be pop out, asking users
     * to put in their names.
     * if it is used: The input from the name field will be stored
     * to SettingsOptions to be used later.
     * At last, it will redirect the user to the level selection screen.
     * @throws IOException
     */
    public void levelSelection() throws IOException {

        if(m_Name.getLength() <= 0){
            m_Tips.setVisible(true);
        }
        else {
            Model_SettingsOptions.setM_name(m_Name.getText());
            SceneControl.switchScene(Model_Scenes.Level);
        }
    }


    /**
     * @Description:
     * switchToSettings() will utilize SceneControl class method,
     * it will redirect the user to the settings screen.
     * @throws IOException
     */

    public void switchToSettings() throws IOException {

        SceneControl.switchScene(Model_Scenes.Settings);

    }

    /**
     * @Description:
     * switchToLeaderboard() will utilize SceneControl class method,
     * it will redirect the user to the leaderboard screen.
     * @throws IOException
     */
    public void switchToLeaderboard() throws IOException {

        SceneControl.switchScene(Model_Scenes.Leaderboard);
    }

}

package com.Brax.Controller;

import com.Brax.*;
import com.Brax.Model.Model_Scenes;
import com.Brax.Model.Model_SettingsOptions;
import com.Brax.View.View_MyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class Controller_Levels {
    /**
     *(Level Screen)
     *m_Level1, m_Level2, and m_Level3 belong to the level screen
     *m_LevelGroup is a ToggleGroup which prevents the users from
     *choosing more than 1 level at a time
     */

    @FXML
    private ToggleGroup m_LevelGroup = new ToggleGroup();
    @FXML
    private RadioButton m_Level1;
    @FXML
    private RadioButton m_Level2;
    @FXML
    private RadioButton m_Level3;

    /**
     * @Descripion
     * selLevel1(), selLevel2(), and selLevel3() are used by
     * m_Level1, m_Level2, and m_Level3 to set the
     * difficulty of the game according to the user's
     * choice. The speed will be changed accordingly
     * to the user's choice. The speed is default at
     * 5.
     */

    public void selLevel1() {
        m_Level1.setToggleGroup(m_LevelGroup);
        Model_SettingsOptions.setSpeed(5);
    }
    public void selLevel2() {
        m_Level2.setToggleGroup(m_LevelGroup);
        Model_SettingsOptions.setSpeed(10);
    }
    public void selLevel3() {
        m_Level3.setToggleGroup(m_LevelGroup);
        Model_SettingsOptions.setSpeed(15);
    }
    @FXML
    private Button m_StartButton;

    /**
     * @Descripion
     * startGame() is linked to m_startButton
     * When m_StartButton is clicked,
     * it will create a new Play object and the loadFrame
     * method will be loaded.
     * It will then utilize getMusicPlay method from MusicPlayer class to play
     * a soundtrack by obtaining the filepath of the soundtrack.
     * The method will terminate after the frame as been set to visible.
     */

    public void startGame() {
        m_StartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controller_MusicPlayer mp = new Controller_MusicPlayer();
                new Play().loadFrame();
                mp.play();
                View_MyFrame.m_jFrame.setVisible(true);
            }
        });
    }

    /**
     * @Descripion
     * There is a back button on the levels screen.
     * When users click on it, it will utilize
     * switchScene() method from the SceneControl class,
     * which switches the scene using another fxml file.
     * It will take users back to the main menu.
     * @throws IOException
     */

    public void switchToMenu() throws IOException {

        SceneControl.switchScene(Model_Scenes.Menu);

    }

}

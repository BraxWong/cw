package com.Brax.View;
import com.Brax.SceneControl;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class View_Menu extends Application {

    private final int FRAME_X = 870;
    private final int FRAME_Y = 543;

    /**
     * main() will call start as soon as it runs.
     * Which will load a FXML file and put it up on the screen
     * for display
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * start() will be launched as soon as the program is started.
     * It will load the fxml file for the menu screen using FXMLLoader.
     * The using SceneControl to set the scene to the scene with the FXML file.
     * Added the snake-logo to the game icon and frame's title
     * When the stage is closed, both platform and system will exit.
     * @FIXME
     * MenuScreen.fxml shouldn't be in the same package.
     * It won't work unless it is
     * @param stage
     * @throws IOException
     */


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuScreen.fxml"));
        Scene scene = new Scene(loader.load(),FRAME_X,FRAME_Y);
        SceneControl.setScene(scene);
        Image icon = new Image("com/Brax/snakeModel/snake-logo.png");
        stage.getIcons().add(icon);
        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

}

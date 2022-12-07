package com.Brax;

import com.Brax.Model.Model_Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class SceneControl {
    private static Scene scene;

    /**
     * setScene() takes in a scene object as an argument
     * the store it in the scene member variable.
     * It allows users to set the scene.
     * @param scene
     */
    public static void setScene(Scene scene){
        SceneControl.scene = scene;
    }

    /**
     * switchScene() allows user to switch to a different scene
     * using a different FXML files with Scenes ENUM,
     * which stores the various file paths.
     * @param modelScenes
     * @throws IOException
     */
    public static void switchScene(Model_Scenes modelScenes) throws IOException {
        Parent root = FXMLLoader.load(SceneControl.class.getResource(modelScenes.getFilePath()));
        scene.setRoot(root);
    }
}

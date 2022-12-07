package com.Brax.Controller;
import com.Brax.Model.Model_LeaderboardEntry;
import com.Brax.Model.Model_Scenes;
import com.Brax.SceneControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;


public class Controller_Leaderboard implements Initializable {

    /**
        (Leaderboard Screen)
         Consists of m_LeaderboardTable, m_PlayerNameColumn, m_ScoreColumn, and m_Ranking.
     */

    @FXML
    public TableView<Model_LeaderboardEntry> m_LeaderboardTable
            = new TableView<Model_LeaderboardEntry>();
    @FXML
    public TableColumn<Model_LeaderboardEntry,String> m_PlayerNameColumn
            = new TableColumn<>();
    @FXML
    public TableColumn<Model_LeaderboardEntry,Integer> m_ScoreColumn
            = new TableColumn<>();

    private ObservableList<Model_LeaderboardEntry> m_Ranking
            = FXCollections.observableArrayList();

    /**
     * @Descripion
     * populate() takes in a FileSystem object as an argument
     * fs contains a vector of Player, which contains player name and score
     * Using the for loop to get each of the entry
     * Add the entry into the observable list
     * sort the list in descending order for the score column
     * @param fs
     * @throws FileNotFoundException
     */

    public void populate(Controller_FileSystem fs) throws FileNotFoundException {

        for(int i = 0; i < fs.readFile().size(); ++i){

            Model_LeaderboardEntry entry = fs.readFile().get(i);

            m_Ranking.add(new Model_LeaderboardEntry
                    (entry.getM_playerName(),entry.getM_score()));

        }

        Collections.sort(m_Ranking, Comparator.comparingInt
                (Model_LeaderboardEntry::getM_score).reversed());

    }

    /**
     * @Descripion
     * initialize() will be activated as soon as Controller_leaderboard
     * is loaded. It will create a FileSystem object
     * fs will then be passed into populate() to fill it with player entries
     * TableView m_table will be filled with ranking
     * The TableView will be shown as soon as Leaderboard screen is
     * shown.
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Controller_FileSystem fs = new Controller_FileSystem();

        try {

            populate(fs);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }

        m_PlayerNameColumn.setCellValueFactory(new PropertyValueFactory<>
                ("m_playerName"));

        m_ScoreColumn.setCellValueFactory(new PropertyValueFactory<>
                ("m_score"));

        m_LeaderboardTable.setItems(m_Ranking);
    }

    /**
     * @Descripion
     * The leaderboard screen contains a back button,
     * which allows users to go back to the main menu.
     * @throws IOException
     */

    public void switchToMenu() throws IOException {

        SceneControl.switchScene(Model_Scenes.Menu);

    }

}


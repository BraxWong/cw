package com.Brax.Controller;

import com.Brax.Model.Model_FileSystem;
import com.Brax.Model.Model_LeaderboardEntry;

import java.io.*;
import java.util.Vector;

public class Controller_FileSystem {
    Model_FileSystem m_FileSys = new Model_FileSystem();
    /**
     * createScoreFile() will create a file according to the file path,
     * append the name and score to the right cell,
     * then close the object.
     * This method will be activated after the snake has died.
     * @param playerName
     * @param score
     * @throws IOException
     */
    public void createScoreFile(String playerName, int score)
            throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(
                m_FileSys.getM_recordFilePath(),true);

        fileOutputStream.write((playerName + "," + score + "\r\n").getBytes());

        fileOutputStream.close();

    }

    /**
     * readFile() will return a vector of type LeaderboardEntry,
     * which consists of m_playerName(String) and m_score (int).
     * The method will first read the record.csv,
     * then store each row of cells to line,
     * then line will be added into leaderboardEntries,
     * After BufferReader is done reading the file,
     * the method will end with leaderboardEntries being returned
     * @return
     * @throws FileNotFoundException
     */

    public Vector<Model_LeaderboardEntry> readFile() throws
            FileNotFoundException {

        Vector<Model_LeaderboardEntry> leaderboardEntries = new Vector<>();


        try(BufferedReader br = new BufferedReader(
                new FileReader(m_FileSys.getM_recordFilePath()))) {

            for(String line; (line = br.readLine()) != null;){

                String[] sp = line.split(",");

                leaderboardEntries.add(new Model_LeaderboardEntry(
                        sp[0],Integer.parseInt(sp[1])));
            }

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

        return leaderboardEntries;

    }

}

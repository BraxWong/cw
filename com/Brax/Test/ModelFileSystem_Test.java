package com.Brax.Test;
import com.Brax.Controller.Controller_FileSystem;
import com.Brax.Model.Model_FileSystem;
import com.Brax.Model.Model_LeaderboardEntry;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Vector;

import static org.junit.Assert.*;

public class ModelFileSystem_Test {

    Model_FileSystem fs = new Model_FileSystem();
    /**
     * testFileExist() checks whether the file exists or is it just a directory.
     * The FileSystem class consists a String variable which contains the file to the
     * record.csv file.
     * The csv file will be added to the newly created File object and check
     * if the file exists and if it is just a directory.
     */
    @Test
    public void testFileExist() {

        String filePath = fs.getM_recordFilePath();

        File file = new File(filePath);

        assertEquals(file.exists(),true);

        assertEquals(file.isDirectory(),false);

    }

}

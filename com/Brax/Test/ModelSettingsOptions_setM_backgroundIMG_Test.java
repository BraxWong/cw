package com.Brax.Test;
import com.Brax.Model.Model_SettingsOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelSettingsOptions_setM_backgroundIMG_Test {
    /**
     * testBackgroundIMG() is run during the execution of the program.
     * It will retrieve the value from the SettingsOptions class based on
     * the radioButton being clicked from the settings screen.
     * The value can only be 1,2,or 3.
     * (There are three background images to choose from)
     */

    private final int BACKGROUND_IMG_2 = 2;
    private final int BACKGROUND_IMG_3 = 3;
    @Test
    public void testBackgroundIMG() {
        int IMG = Model_SettingsOptions.getM_backgroundImg();
        if(IMG == 1){
            assertEquals(IMG,1);
        }
        else if(IMG == 2){
            assertEquals(IMG,BACKGROUND_IMG_2);
        }
        else {
            assertEquals(IMG, BACKGROUND_IMG_3);
        }
    }
}

package com.Brax.Test;

import com.Brax.Model.Model_SettingsOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelSettingsOptions_setSpeed_Test {
    /**
     * testSpeed() is run during the execution of the program.
     * It will check the speed after the radioButton has been clicked.
     * It can only be 5,10, or 15.
     */
    private final int EASY_SPEED = 5;
    private final int MEDIUM_SPEED = 10;
    private final int HARD_SPEED = 15;
    @Test
    public void testSpeed() {
        int speed = Model_SettingsOptions.getSpeed();
        if(speed == 5){
            assertEquals(speed, EASY_SPEED);
        }
        else if(speed == 10){
            assertEquals(speed, MEDIUM_SPEED);
        }
        else {
            assertEquals(speed, HARD_SPEED);
        }
    }
}

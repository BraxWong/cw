package com.Brax.Test;
import com.Brax.Model.Model_SettingsOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelSettingsOptions_setM_snakeHeadIMG_Test {
    /**
     * testSnakeHeadIMG() is run during the execution of the program,
     * it will check whether the value is 1 or 2.
     * (It can only be 1 or 2 since there are two images to choose from)
     */

    private final int SNAKE_HEAD2 = 2;
    @Test
    public void testSnakeHeadIMG(){
        int IMG = Model_SettingsOptions.getM_snakeHeadImg();
        if(IMG == 1){
            assertEquals(IMG,1);
        }
        else {
            assertEquals(IMG, SNAKE_HEAD2);
        }
    }
}

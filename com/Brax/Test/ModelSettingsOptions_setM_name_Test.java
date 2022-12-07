package com.Brax.Test;
import com.Brax.Model.Model_SettingsOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelSettingsOptions_setM_name_Test {
    /**
     * checkNameLength() is run during the execution of the program,
     * it will check whether the name is null
     * (which means users did not put their names in)
     */
    @Test
    public void checkNameLength() {
        String name = Model_SettingsOptions.getM_name();
        assertNotEquals(name.length(),null);
    }

}

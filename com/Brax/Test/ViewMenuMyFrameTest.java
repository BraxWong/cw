package com.Brax.Test;

import com.Brax.View.View_MyFrame;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ViewMenuMyFrameTest {
    View_MyFrame frame = new View_MyFrame();

    /**
     * checkFramePropertiesValue() makes sure the JFrame is
     * not null.
     */
    @Test
    public void checkFramePropertiesValue() {
        assertNotEquals(frame.m_jFrame,null);
    }
}

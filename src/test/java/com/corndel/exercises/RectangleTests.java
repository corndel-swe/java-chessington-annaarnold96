package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {

    @Test
    public void checkRectangleArea(){
        var width = 10;
        var height = 5;

        Rectangle rectangle = new Rectangle(width, height);

        var result = rectangle.getArea();

        assertEquals(50,result);
    }

    @Test
    public void checkRectanglePerimeter(){
        var width = 10;
        var height = 5;

        Rectangle rectangle = new Rectangle(width, height);

        var result = rectangle.getPerimeter();

        assertEquals(30,result);
    }
}

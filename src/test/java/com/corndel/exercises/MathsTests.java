package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {

    @Test
    public void isPiCorrect(){
        assertTrue(Maths.PI == 3.14);
    }

    @Test
    public void doesMaxReturnLargest(){
        int a = 10;
        int b = 25;
        var result = Maths.max(a,b);

        assertEquals(25, result);
    }

    @Test
    public void returnsSameNumberWithWholeNumber(){
        double a = 5;

        double result = Maths.round(a);

        assertEquals(5, result);
    }

    @Test
    public void roundsDown(){
        double a = 1.3;

        double result = Maths.round(a);

        assertEquals(1, result);
    }

    @Test
    public void roundsUp(){
        double a = 1.7;

        double result = Maths.round(a);

        assertEquals(2, result);
    }

}

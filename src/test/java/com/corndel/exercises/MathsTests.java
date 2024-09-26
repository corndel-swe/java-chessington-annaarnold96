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

}

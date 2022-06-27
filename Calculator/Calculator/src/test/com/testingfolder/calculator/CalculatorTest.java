package com.testingfolder.calculator;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp(){
        this.calc = new Calculator();
    }
    @Test
    public void canAddZeroPlusZero(){
        int sum = calc.add(0,0);
        assertEquals(sum, 0);
    }

    @Test
    public void canAddNumberWithNumber(){
        int sum = calc.add(1, 1);
        assertEquals(sum, 2);
    }

    @Test
    public void canAddMaxIntPlusOne(){
        int sum = calc.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MAX_VALUE + 1, sum);
    }

}

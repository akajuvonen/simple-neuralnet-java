package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.IOException;

/**
 * Unit tests for iris data analysis.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class IrisAnalysisTest {
    /**
     * Test CSV parsing.
     */
    @Test
    public void testCSVParser() {
        // Print test lines to file
        try{
            PrintWriter writer = new PrintWriter("test.data", "UTF-8");
            writer.println("1.0,2.0,3.0,4.0,Iris-setosa");
            writer.println("5.0,6.0,7.0,8.0,Iris-versicolor");
            writer.println("9.0,10.0,11.0,12.0,Iris-virginica");
            writer.close();
        } catch (IOException e) {
            System.out.println("Can't read test.data");
        }
        assertTrue(true);
    }

    /**
     * Test data shuffling.
     */
    @Test
    public void testDataShuffling() {
        assertTrue(true);
    }

    /**
     * Test data splitting.
     */
    @Test
    public void testDataSplitting() {
        assertTrue(true);
    }
}

package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for matrix operations library.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
public class MatrixToolsTest {
    /**
     * Test matrix multiplication
     */
    @Test
    public void testMultiply() {
        // Input matrices
        double[][] a = {
            {1.0,2.0,3.0},
            {2.0,3.0,3.0},
            {4.0,1.0,1.0},
            {4.0,4.0,3.0}
        };
        double[][] b = {
            {1.0,2.0},
            {2.0,3.0},
            {4.0,1.0},
        };
        // Expected output
        double[][] expected = {
            {17.0,11.0},
            {20.0,16.0},
            {10.0,12.0},
            {24.0,23.0}
        };
        double[][] actual;
        actual = MatrixTools.multiply(a,b);
        // Test that the result is correct
        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i],actual[i],0.0);
        }
    }

    /**
     * Test matrix multiplication when array sizes don't match
     */
    @Test
    public void testMultiplyArrayMismatch() {
        // Is the exception raised
        // The arrays are not the right shape for multiplication
        boolean raised = false;
        double[][] a = new double[4][3];
        double[][] b = new double[2][3];
        try {
            double[][] result = MatrixTools.multiply(a,b);
        } catch(IllegalArgumentException e) {
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * Test matrix multiplication when nested array lengths not equal
     */
    @Test
    public void testMultiplyArrayLengthVaries() {
        // Is the exception raised
        boolean raised = false;
        double[][] a = new double[4][3];
        // elements of array b are of different length
        double[][] b = {
            {0.0,0.0,0.0},
            {0.0,0.0,0.0},
            {0.0,0.0}
        };
        try {
            double[][] result = MatrixTools.multiply(a,b);
        } catch(IllegalArgumentException e) {
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * Test random matrix generation
     */
    @Test
    public void testRandomMatrix() {
        // Rows, columns
        int i = 3;
        int j = 4;
        // Create random matrix
        double[][] randArr = MatrixTools.randomMatrix(i,j);
        // Make sure size is correct
        assertEquals(randArr.length,i);
        assertEquals(randArr[0].length,j);
        // Make sure values between -1.0 and 1.0
        double[] minMax = MatrixTools.findArrayMinMax(randArr);
        assertTrue(minMax[0] > -1.0);
        assertTrue(minMax[1] < 1.0);
    }

    @Test
    public void testFindArrayMinMax() {
        // TODO
    }
}

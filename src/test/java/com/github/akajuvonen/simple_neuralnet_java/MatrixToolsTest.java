package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * Unit tests for matrix operations library.
 *
 * @author Antti Juvonen
 * @version 0.1
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
    }

    /**
     * Test matrix multiplication when nested array lengths not equal
     */
    @Test
    public void testMultiplyArrayLengthVaries() {
    }
}

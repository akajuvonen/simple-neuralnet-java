package com.github.akajuvonen.simple_neuralnet_java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for matrix operations library.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class MatrixToolsTest
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MatrixToolsTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MatrixToolsTest.class);
    }

    /**
     * Test matrix multiplication
     */
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
      assertEquals(expected,actual);
    }

    /**
     * Test matrix multiplication when array sizes don't match
     */
    public void testMultiplyArrayMismatch() {
    }

    /**
     * Test matrix multiplication when nested array lengths not equal
     */
    public void testMultiplyArrayLengthVaries() {
    }
}

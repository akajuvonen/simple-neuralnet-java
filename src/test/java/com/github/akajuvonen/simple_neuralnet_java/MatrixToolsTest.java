package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for matrix operations library.
 *
 * @author Antti Juvonen
 * @version 1.0
 */
public class MatrixToolsTest {
    /**
     * Test matrix multiplication.
     */
    @Test
    public void testMultiply() {
        // Input matrices
        double[][] a = {
            {1.0, 2.0, 3.0},
            {2.0, 3.0, 3.0},
            {4.0, 1.0, 1.0},
            {4.0, 4.0, 3.0}
        };
        double[][] b = {
            {1.0, 2.0},
            {2.0, 3.0},
            {4.0, 1.0},
        };
        // Expected output
        double[][] expected = {
            {17.0, 11.0},
            {20.0, 16.0},
            {10.0, 12.0},
            {24.0, 23.0}
        };
        double[][] actual;
        actual = MatrixTools.multiply(a,b);
        // Test that the result is correct
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 0.0);
        }
    }

    /**
     * Test matrix multiplication when array sizes don't match.
     */
    @Test
    public void testMultiplyArrayMismatch() {
        // Is the exception raised
        // The arrays are not the right shape for multiplication
        boolean raised = false;
        double[][] a = new double[4][3];
        double[][] b = new double[2][3];
        try {
            double[][] result = MatrixTools.multiply(a, b);
        } catch (IllegalArgumentException e) {
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * Test matrix multiplication when nested array lengths not equal.
     */
    @Test
    public void testMultiplyArrayLengthVaries() {
        // Is the exception raised
        boolean raised = false;
        double[][] a = new double[4][3];
        // elements of array b are of different length
        double[][] b = {
            {0.0, 0.0, 0.0},
            {0.0, 0.0, 0.0},
            {0.0, 0.0}
        };
        try {
            double[][] result = MatrixTools.multiply(a,b);
        } catch (IllegalArgumentException e) {
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * Test that one element of multiplication can be a vector.
     */
    @Test
    public void testMultiplyOneDimensional() {
        // The first element is a vector
        double[][] a = {
            {1, 2, 3}
        };
        double[][] b = {
            {1, 2, 3},
            {2, 3, 4},
            {3, 4, 5}
        };
        double[][] result1 = MatrixTools.multiply(a, b);
        assertEquals(result1.length, 1);
        assertEquals(result1[0].length, 3);
        // The second element is a vector
        double[][] c = {
            {1},
            {2},
            {3}
        };
        double[][] d = {
            {1, 2, 3}
        };
        double[][] result2 = MatrixTools.multiply(c, d);
        assertEquals(result2.length, 3);
        assertEquals(result2[0].length, 3);
    }

    /**
     * Multiply matrices element-wise test.
     */
    @Test
    public void testMultiplyElementwise() {
        double[][] a =  {
            {1},
            {2}
        };
        double[][] b =  {
            {1},
            {2}
        };
        double[][] expected = {
            {1},
            {4}
        };
        double[][] actual = MatrixTools.multiplyElementwise(a, b);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 0.0);
        }
    }

    /**
     * Multiply matrix with a scalar test.
     */
    @Test
    public void testMultiplyElementwiseScalar() {
        double[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] b = {
            {2}
        };
        double[][] expected = {
            {2, 4, 6},
            {8, 10 , 12}
        };
        double[][] actual = MatrixTools.multiply(a, b);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 0.0);
        }
    }

    /**
     * Test random matrix generation.
     */
    @Test
    public void testRandomMatrix() {
        // Rows, columns
        int i = 3;
        int j = 4;
        // Create random matrix
        double[][] randArr = MatrixTools.randomMatrix(i, j);
        // Make sure size is correct
        assertEquals(randArr.length, i);
        assertEquals(randArr[0].length, j);
        // Make sure values between -1.0 and 1.0
        double[] minMax = MatrixTools.findArrayMinMax(randArr);
        assertTrue(minMax[0] > -1.0);
        assertTrue(minMax[1] < 1.0);
    }

    /**
     * Random matrix generation should return an error if array size
     * ints negative or zeros.
     */
    @Test
    public void testRMSizeNotPositiveInt() {
        // Check for zeros
        boolean raised = false;
        try {
            MatrixTools.randomMatrix(0, 0);
        } catch (IllegalArgumentException e) {
            raised = true;
        }
        assertTrue(raised);
        // Check for negative numbers
        raised = false;
        try {
            MatrixTools.randomMatrix(-1, -2);
        } catch (IllegalArgumentException e) {
            raised = true;
        }
        assertTrue(raised);
    }

    /**
     * Test that finding array min and max works correctly.
     */
    @Test
    public void testFindArrayMinMax() {
        double min = -1.0;
        double max = 2.0;
        double[][] a = {
            {1.0, max, 1.0},
            {0.0, min}
        };
        double[] minMax = MatrixTools.findArrayMinMax(a);
        assertEquals(minMax[0], min, 0.0);
        assertEquals(minMax[1], max, 0.0);
    }

    /**
     * Test that transpose works.
     */
    @Test
    public void testTranspose() {
        double[][] x = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        double[][] expected = {
            {1, 3, 5},
            {2, 4, 6}
        };
        double[][] y = MatrixTools.transpose(x);
        // Test that the result is correct
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], y[i], 0.0);
        }
    }

    /**
     * Test that transpose works with 1d nested arrays.
     */
    @Test
    public void testTransposeOneDimensional() {
        // Case 1
        double[][] input1 = {
            {1, 2, 3}
        };
        double[][] expected1 = {
            {1},
            {2},
            {3}
        };
        double[][] actual1 = MatrixTools.transpose(input1);
        // Test that the result is correct
        for (int i = 0; i < expected1.length; i++) {
            assertArrayEquals(expected1[i], actual1[i], 0.0);
        }
        // Case 2
        double[][] input2 = {
            {1},
            {2},
            {3}
        };
        double[][] expected2 = {
            {1, 2, 3}
        };
        double[][] actual2 = MatrixTools.transpose(input2);
        // Test that the result is correct
        for (int i = 0; i < expected2.length; i++) {
            assertArrayEquals(expected2[i], actual2[i], 0.0);
        }
    }

    /**
     * Test that substraction works.
     */
    @Test
    public void testSubstraction() {
        double[][] a = {
            {1, 2},
            {3, 4}
        };
        double[][] b = {
            {5, 6},
            {7, 8}
        };
        double[][] expected = {
            {-4, -4},
            {-4, -4}
        };
        double[][] actual = MatrixTools.substraction(a,b);
        // Check the results
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 0.0);
        }
    }

    /**
     * Test that addition works.
     */
    @Test
    public void testAddition() {
        double[][] a = {
            {1, 2},
            {3, 4}
        };
        double[][] b = {
            {5, 6},
            {7, 8}
        };
        double[][] expected = {
            {6, 8},
            {10, 12}
        };
        double[][] actual = MatrixTools.addition(a,b);
        // Check the results
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 0.0);
        }
    }
}

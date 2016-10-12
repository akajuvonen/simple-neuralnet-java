package com.github.akajuvonen.simple_neuralnet_java;

import java.util.Random;

/**
 * Matrix operations library.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
final class MatrixTools {
    /**
     * A private constructorfor MatrixTools.
     * This exists because java creates a public constructor
     * by default, which we don't want.
     */
    private MatrixTools() {
        throw new AssertionError("Trying to instantiate a utility class");
    }

    /**
     * A helper method to check if all nested array's elements
     * have the same length.
     *
     * @param a A double[][] nested array
     * @return False if not equal, otherwise true
     */
    private static boolean lengthsEqual(final double[][] a) {
        int length = a[0].length;
        for (int i = 1; i < a.length; i++) {
            if (a[i].length != length) {
                return false;
            }
            length = a[i].length;
        }
        return true;
    }

    /**
     * Matrix multiplication. Takes two array as input.
     *
     * @param a First array
     * @param b Second array
     * @return c The resulting matrix
     */
    static double[][] multiply(final double[][] a, final double[][] b) {
        // If the matrix sizes not suitable for multiplication
        if (a[0].length != b.length) {
            throw new IllegalArgumentException(
            "The matrix sizes do not match for multiplication");
        }
        // Check that the input nested array lengths are equal
        if (!lengthsEqual(a) || !lengthsEqual(b)) {
            throw new IllegalArgumentException(
            "The nested matrix lengths are not equal");
        }

        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int k = 0; k < b[0].length; k++) {
                    c[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        return c;
    }

    /**
     * Create a random matrix with values from -1 to 1.
     *
     * @param x Number of lines in return array
     * @param y Number of columns in return array
     * @return randMatrix The random nested array
     */
    static double[][] randomMatrix(final int x, final int y) {
        Random r = new Random();
        double[][] randMatrix = new double[x][y];
        for (int i = 0; i < randMatrix.length; i++) {
            for (int j = 0; j < randMatrix[i].length; j++) {
                // Random values between -1.0 and 1.0
                randMatrix[i][j] = 2 * r.nextDouble() - 1.0;
            }
        }
        return randMatrix;
    }

    /**
     * Find the minimum and maximum value from a double nested array.
     */
    static double[] findArrayMinMax(double[][] arr) {
        double min = arr[0][0];
        double max = arr[0][0];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > max) {
                    max = arr[i][j];
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        double[] minMax = { min, max };
        return minMax;
    }
}

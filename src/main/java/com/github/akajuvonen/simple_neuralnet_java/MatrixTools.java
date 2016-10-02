package com.github.akajuvonen.simple_neuralnet_java;

/**
 * Matrix operations library.
 *
 * @author Antti Juvonen
 * @version 0.2
 */
public class MatrixTools {
  /**
   * Matrix multiplication. Takes two array as input.
   *
   * @param a First array
   * @param b Second array
   * @return c The resulting matrix
   */
  public static double[][] multiply(double[][] a, double[][] b) {
    double[][] c = new double[a.length][b[0].length];
    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < a[0].length; j++) {
        for(int k = 0; k < b[0].length; k++) {
          c[i][k] += a[i][j] * b[j][k];
        }
      }
    }
    return c;
  }
}

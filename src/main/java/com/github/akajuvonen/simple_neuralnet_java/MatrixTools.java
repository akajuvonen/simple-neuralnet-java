package com.github.akajuvonen.simple_neuralnet_java;

/**
 * Matrix operations library.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
public class MatrixTools {

  /**
   * A helper method to check if all nested array's elements have the same length.
   *
   * @param a A double[][] nested array
   * @return False if not equal, otherwise true
   */
  private static boolean lengthsEqual(double[][] a) {
    int length = a[0].length;
    for(int i = 1; i < a.length; i++) {
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
  public static double[][] multiply(double[][] a, double[][] b) {
    // If the matrix sizes not suitable for multiplication
    if(a[0].length != b.length) {
      throw new IllegalArgumentException("The matrix sizes do not match for multiplication");
    }
    // Check that the input nested array lengths are equal
    if(!lengthsEqual(a) || !lengthsEqual(b)) {
      throw new IllegalArgumentException("The nested matrix lengths are not equal");
    }

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

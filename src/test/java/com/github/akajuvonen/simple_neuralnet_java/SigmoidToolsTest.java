package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/**
 * Unit test for sigmoid and derivative functions.
 *
 * @author Antti Juvonen
 * @version 1.0
 */
public class SigmoidToolsTest {
    /**
     * Sigmoid function test
     */
    @Test
    public void testSigmoid() {
        double i, result;
        // sigmoid(-10) should be close to zero
        i = -10.0;
        result = SigmoidTools.sigmoid(i);
        assertEquals(result, 0.0, 0.1);
        // sigmoid(10) should be close to 1
        i = 10.0;
        result = SigmoidTools.sigmoid(i);
        assertEquals(result, 1.0, 0.1);
        // sigmoid(0) should be 0.5
        i = 0.0;
        result = SigmoidTools.sigmoid(i);
        assertEquals(result, 0.5, 0.0);
    }

    /**
     * Test that sigmoid works for nested arrays.
     */
    @Test
    public void testSigmoidArray() {
        double[][] input = {
            {-10.0, 0.0, 10.0}
        };
        double[] expected = { 0.0, 0.5, 1.0};
        double[][] result = SigmoidTools.sigmoid(input);
        for (int j = 0; j < input[0].length; j++) {
            assertEquals(expected[j], result[0][j], 0.1);
        }
    }

    /**
     * Sigmoid derivative test
     */
     @Test
     public void testSigmoidDerivative() {
         double i, result;
         // should be close to zero
         i = -10.0;
         result = SigmoidTools.sigmoidDerivative(SigmoidTools.sigmoid(i));
         assertEquals(result, 0.0, 0.1);
         // should be close to 0
         i = 10.0;
         result = SigmoidTools.sigmoidDerivative(SigmoidTools.sigmoid(i));
         assertEquals(result, 0.0, 0.1);
         // should be 0.25
         i = 0.0;
         result = SigmoidTools.sigmoidDerivative(SigmoidTools.sigmoid(i));
         assertEquals(result, 0.25, 0.0);
     }

    /**
     * Test that sigmoid derivative works for nested arrays.
     */
    @Test
    public void testSigmoidDerivativeArray() {
        double[][] input = {
            {-10.0,0.0,10.0}
        };
        double[] expected = { 0.0, 0.25, 0.0};
        double[][] result = SigmoidTools.sigmoidDerivative(
            SigmoidTools.sigmoid(input));
        for (int j = 0; j < input[0].length; j++) {
            assertEquals(expected[j], result[0][j], 0.1);
        }
    }
}

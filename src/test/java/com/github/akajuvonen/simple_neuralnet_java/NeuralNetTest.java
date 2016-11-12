package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for neural network.
 *
 * @author Antti Juvonen
 * @version 1.0
 */
public class NeuralNetTest {
    /**
     * Neural net sanity test.
     */
    @Test
    public void testNeuralNet() {
        // Input data for training
        double[][] trainIn = {
            {1.0, 0.0, 0.0},
            {0.0, 0.0, 1.0},
            {1.0, 1.0, 1.0},
            {1.0, 1.0, 0.0},
            {0.0, 1.0, 0.0},
            {0.0, 0.0, 0.0}
        };
        // Training data outputs
        double[][] trainOut = {
            {1.0},
            {0.0},
            {1.0},
            {1.0},
            {0.0},
            {0.0}
        };
        double[][] testIn = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 1, 1}
        };
        final int hiddenSize = 4;
        final int maxIterations = 60000;
        NeuralNet net = new NeuralNet(hiddenSize, maxIterations,
            trainIn, trainOut);
        double[][] result = net.classify(testIn);
        // Expected results
        double[] expected = {1, 0, 1};
        for (int i = 0; i < result.length; i++) {
            // Should be rounded to 1 0 1
            assertEquals(result[i][0], expected[i], 0.1);
        }
    }
}

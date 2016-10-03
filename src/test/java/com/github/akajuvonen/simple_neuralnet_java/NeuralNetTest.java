package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for neural network.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class NeuralNetTest {
  /**
   * Neural net sanity test.
   */
  @Test
  public void testNeuralNet() {
      // Create a new net
      NeuralNet net = new NeuralNet(4,10000);
      assertTrue(true);
  }
}

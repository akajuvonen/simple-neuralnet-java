package com.github.akajuvonen.simple_neuralnet_java;

/**
 * NeuralNet class.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
public class NeuralNet {
    /**
     * Hidden layer size (nodes).
     */
    private int hiddenSize;
    /**
     * Max number of iterations to run for training the network.
     */
    private int maxIterations;
    /**
     * A flag to check if the network is already trained.
     */
    private boolean trained;
    /**
     * Weights between input and hidden layer.
     */
    private double[][] weights1;
    /**
     * Weights between hidden and output layer.
     */
    private double[][] weights2;

    /**
     * The NeuralNet class constructor.
     *
     * @param hidSize The size of the hidden layer in nodes
     * @param maxIter After how many iterations stop the training
     */
    public NeuralNet(final int hidSize, final int maxIter) {
        this.hiddenSize = hidSize;
        this.maxIterations = maxIter;
        this.trained = false;
    }

    /**
     * Trains the network using training data.
     *
     * @param trainIn The training input data (observations)
     * @param trainOut The training output data (expected classifications)
     */
    public final void train(final double[][] trainIn,
                            final double[][] trainOut) {
        this.trained = true;
        System.out.println("This is the train method");
    }

    /**
     * Classifies new data.
     */
     public final void classify() {
         System.out.println("This is the classify method");
     }

     /**
      * The main method.
      *
      * @param args the standard command line arguments
      */
      public static void main(final String[] args) {
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
          final int hiddenSize = 4;
          final int maxIterations = 60000;
          NeuralNet net = new NeuralNet(hiddenSize, maxIterations);
          net.train(trainIn, trainOut);
          net.classify();
      }
}

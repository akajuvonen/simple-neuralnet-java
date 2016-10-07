package com.github.akajuvonen.simple_neuralnet_java;

/**
 * NeuralNet class.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
public class NeuralNet {
    // hidden layer size
    private int hiddenSize;
    // max iterations to run training
    private int maxIterations;
    // is the network already trained
    private boolean trained;
    // weights between input and hidden layer
    private double[][] weights1;
    // weights between hidden and output layer
    private double[][] weights2;

    /**
    * The NeuralNet class constructor.
    *
    * @param hidSize The size of the hidden layer in nodes
    * @param maxIter After how many iterations stop the training
    */
    public NeuralNet(int hidSize, int maxIter) {
        this.hiddenSize = hiddenSize;
        this.maxIterations = maxIterations;
        this.trained = false;
    }

    /**
    * Trains the network using training data.
    *
    * @param trainIn The training input data (observations)
    * @param trainOut The training output data (expected classifications)
    */
    public final void train(double[][] trainIn, double[][] trainOut) {
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
      public static void main(String[] args) {
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
          NeuralNet net = new NeuralNet(4, 60000);
          net.train(trainIn, trainOut);
          net.classify();
      }
}

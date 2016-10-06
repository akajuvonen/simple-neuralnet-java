package com.github.akajuvonen.simple_neuralnet_java;

// For printing arrays
import java.util.Arrays;

/**
 * NeuralNet class.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
public class NeuralNet {
    // hidden layer size
    private int hidden_size;
    // max iterations to run training
    private int max_iterations;
    // is the network already trained
    private boolean trained;
    // weights between input and hidden layer
    private double[][] weights_1;
    // weights between hidden and output layer
    private double[][] weights_2;

    /**
    * The NeuralNet class constructor.
    *
    * @param hidden_size The size of the hidden layer in nodes
    * @param max_iterations After how many iterations stop the training
    */
    public NeuralNet(int hidden_size, int max_iterations) {
        this.hidden_size = hidden_size;
        this.max_iterations = max_iterations;
        this.trained = false;
    }

    /**
    * Trains the network using training data.
    *
    * @param train_in The training input data (observations)
    * @param train_out The training output data (expected classifications)
    */
    public void train(double[][] train_in, double[][] train_out) {
        this.trained = true;
        System.out.println("This is the train method");
        // Print out nested arrays using deep to string method
        System.out.println(Arrays.deepToString(train_in));
        System.out.println(Arrays.deepToString(train_out));
        System.out.println(SigmoidTools.sigmoid(10));
    }

    /**
     * Classifies new data.
     */
     public void classify() {
         System.out.println("This is the classify method");
     }

     /**
      * The main method.
      *
      * @param args the standard command line arguments
      */
      public static void main(String[] args) {
          // Input data for training
          double[][] train_in = {
              {1.0, 0.0, 0.0},
              {0.0, 0.0, 1.0},
              {1.0, 1.0, 1.0},
              {1.0, 1.0, 0.0},
              {0.0, 1.0, 0.0},
              {0.0, 0.0, 0.0}
          };
          // Training data outputs
          double[][] train_out = {
              {1.0},
              {0.0},
              {1.0},
              {1.0},
              {0.0},
              {0.0}
          };
          NeuralNet net = new NeuralNet(4, 60000);
          net.train(train_in, train_out);
          net.classify();
      }
}

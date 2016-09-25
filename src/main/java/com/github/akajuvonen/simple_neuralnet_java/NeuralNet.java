package com.github.akajuvonen.simple_neuralnet_java;

// For printing arrays
import java.util.Arrays;

/**
 * NeuralNet class.
 */
public class NeuralNet
{
  private int hidden_size;
  private int max_iterations;
  private boolean trained;

  public NeuralNet(int hidden_size, int max_iterations) {
    hidden_size = hidden_size;
    max_iterations = max_iterations;
    trained = false;
  }

  /**
   * Trains the network using training data.
   *
   * @param train_in The training input data (observations)
   * @param train_out The training output data (expected classifications)
   */
  public void train(double[][] train_in, double[][] train_out) {
      System.out.println("This is the train method");
      // Print out nested arrays using deep to string method
      System.out.println(Arrays.deepToString(train_in));
      System.out.println(Arrays.deepToString(train_out));
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
    public static void main( String[] args )
    {
        // Input data for training
        double[][] train_in = new double[][]{
          {1.0,0.0,0.0},
          {0.0,0.0,1.0},
          {1.0,1.0,1.0},
          {1.0,1.0,0.0},
          {0.0,1.0,0.0},
          {0.0,0.0,0.0}
        };
        // Training data outputs
        double[][] train_out = new double[][]{
          {1.0},
          {0.0},
          {1.0},
          {1.0},
          {0.0},
          {0,0}
        };
        NeuralNet net = new NeuralNet(4, 60000);
        net.train(train_in,train_out);
        net.classify();
    }
}

package com.github.akajuvonen.simple_neuralnet_java;

// For printing arrays
import java.util.Arrays;

/**
 * NeuralNet class.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
public class NeuralNet
{
  private int hidden_size;
  private int max_iterations;
  private boolean trained;
  private double[][] weights_1;
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
   * Sigmoid function. Returns 1 / (1+exp(-x)).
   *
   * @param x The input value
   * @return Sigmoid function result
   */
  private double sigmoid(double x) {
    return 1/(1+Math.exp(-x));
  }

  /**
   * Sigmoid derivative function. x*(1-x).
   * The values should already be calculated using
   * the sigmoid method, i.e., the actual derivative
   * is sigmoid(x)*(1-sigmoid(x))
   *
   * @param x The input value
   * @return Sigmoid derivative function result
   */
  private double sigmoid_derivative(double x) {
    return x*(1-x);
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
    public static void main( String[] args )
    {
        // Input data for training
        double[][] train_in = {
          {1.0,0.0,0.0},
          {0.0,0.0,1.0},
          {1.0,1.0,1.0},
          {1.0,1.0,0.0},
          {0.0,1.0,0.0},
          {0.0,0.0,0.0}
        };
        // Training data outputs
        double[][] train_out = {
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

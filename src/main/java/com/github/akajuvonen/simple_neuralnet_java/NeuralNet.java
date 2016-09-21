package com.github.akajuvonen.simple_neuralnet_java;

/**
 * NeuralNet class.
 */
public class NeuralNet
{
  /**
   * Trains the network using training data.
   */
  public void train() {
      System.out.println("This is the train method");
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
        NeuralNet net = new NeuralNet();
        net.train();
        net.classify();
    }
}

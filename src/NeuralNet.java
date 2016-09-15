/**
  * This will be a neural network class.
  */
public class NeuralNet {

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
    public static void main(String[] args) {
        // Doesn't do anything yet
        NeuralNet net = new NeuralNet();
        net.train();
        net.classify();
    }

}

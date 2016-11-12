package com.github.akajuvonen.simple_neuralnet_java;

import static com.github.akajuvonen.simple_neuralnet_java.
    MatrixTools.multiply;
import static com.github.akajuvonen.simple_neuralnet_java.
    MatrixTools.multiplyElementwise;
import static com.github.akajuvonen.simple_neuralnet_java.
    MatrixTools.randomMatrix;
import static com.github.akajuvonen.simple_neuralnet_java.
    MatrixTools.transpose;
import static com.github.akajuvonen.simple_neuralnet_java.
    MatrixTools.substraction;
import static com.github.akajuvonen.simple_neuralnet_java.
    MatrixTools.addition;
import static com.github.akajuvonen.simple_neuralnet_java.
    SigmoidTools.sigmoid;
import static com.github.akajuvonen.simple_neuralnet_java.
    SigmoidTools.sigmoidDerivative;

/**
 * NeuralNet class.
 *
 * @author Antti Juvonen
 * @version 1.0
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
     * Weights between input and hidden layer.
     */
    private double[][] weights1;
    /**
     * Weights between hidden and output layer.
     */
    private double[][] weights2;
    /**
     * The hidden (middle) layer.
     */
    private double[][] hiddenLayer;
    /**
     * The output layer (results).
     */
    private double[][] outputLayer;

    /**
     * The NeuralNet class constructor.
     * Initializes random weights and trains the network.
     *
     * @param hidSize The size of the hidden layer in nodes
     * @param maxIter After how many iterations stop the training
     * @param trainIn Training data inputs
     * @param trainOut Training data expected outputs
     */
    public NeuralNet(final int hidSize, final int maxIter,
        final double[][] trainIn, final double[][] trainOut) {
        hiddenSize = hidSize;
        maxIterations = maxIter;
        // Init weights randomly
        weights1 = randomMatrix(trainIn[0].length, hiddenSize);
        weights2 = randomMatrix(hiddenSize, trainOut[0].length);
        // Train the network
        train(trainIn, trainOut);
    }

    /**
     * Trains the network using training data.
     * Note that training is done once when initializing the network.
     *
     * @param trainIn The training input data (observations)
     * @param trainOut The training output data (expected classifications)
     */
    public final void train(final double[][] trainIn,
                            final double[][] trainOut) {
        double[][] outputError, outputAdjustment, hiddenError, hiddenAdjustment;
        for (int i = 0; i < maxIterations; i++) {
            // Classify data
            classify(trainIn);
            // Calculate errors and adjustments for hidden and output layer
            outputError = substraction(trainOut, outputLayer);
            outputAdjustment = multiplyElementwise(outputError,
                                        sigmoidDerivative(outputLayer));
            hiddenError = multiply(outputAdjustment,
                                   transpose(weights2));
            hiddenAdjustment = multiplyElementwise(hiddenError,
                                        sigmoidDerivative(hiddenLayer));
            // Perform the weight adjustments
            weights2 = addition(weights2, multiply(transpose(hiddenLayer),outputAdjustment));
            weights1 = addition(weights1, multiply(transpose(trainIn),hiddenAdjustment));
        }
    }

    /**
     * Classifies new data.
     *
     * @param input The input data
     * @return The output layer (classification results)
     */
    public final double[][] classify(final double[][] input) {
        hiddenLayer = sigmoid(multiply(input, weights1));
        outputLayer = sigmoid(multiply(hiddenLayer, weights2));
        return outputLayer;
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
        System.out.println("The results (should be 1 0 1): ");
        for (int i = 0; i < result.length; i++) {
            System.out.println(Math.round(result[i][0]));
        }
    }
}

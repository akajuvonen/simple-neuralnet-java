package com.github.akajuvonen.simple_neuralnet_java;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Random;

/**
 * Iris data analysis class.
 *
 * @author Antti Juvonen
 * @version 1.0
 */
public class IrisAnalysis {
    /**
     * The neural net that performs analysis.
     */
    private NeuralNet net;
    /**
     * Iris data row count.
     */
    private final int irisRows = 150;
    /**
     * Iris data column count.
     */
    private final int irisColumns = 5;
    /**
     * How many types of flowers can be found in the data.
     */
    private final int irisFlowerTypes = 3;
    /**
     * Training data inputs.
     */
    private double[][] trainIn;
    /**
     * Training data outputs.
     */
    private double[][] trainOut;
    /**
     * Testing data inputs.
     */
    private double[][] testIn;
    /**
     * Testing data outputs.
     */
    private double[][] testOut;
    /**
     * Test data sample size.
     */
     private final int testSize = 100;
    /**
     * Iris data analysis constructor.
     *
     * @param filename Path to iris data csv file
     * @param separator A string character used to split csv line into tokens
     */
    public IrisAnalysis(final String filename, final String separator) {
        // Init train and test data with correct sizes
        trainIn = new double[testSize][irisColumns - 1];
        trainOut = new double[testSize][irisFlowerTypes];
        testIn = new double[(irisRows - testSize)][irisColumns - 1];
        testOut = new double[(irisRows - testSize)][irisFlowerTypes];
        // Parse data from csv
        double[][] parsed = parseCSV(filename, separator);
        // Shuffle data randomly
        double[][] shuffled = shuffleData(parsed);
        // Split data in half, training and testing
        splitData(shuffled);
        // Init some variables for neural net
        final int hiddenSize = 4;
        final int maxIterations = 100000;
        final double learningRate = 0.01;
        // Init and train neural net
        net = new NeuralNet(hiddenSize, maxIterations, trainIn, trainOut,
                            learningRate);
    }

    /**
     * Getter method for private variable (test outputs).
     *
     * @return Test output array.
     */
    public final double[][] getTestOut() {
        return this.testOut;
    }

    /**
     * Classifies test data using trained network.
     *
     * @return The classification results in an arraghy.
     */
    public final double[][] classify() {
        // Classify data using neural net
        double[][] result = net.classify(testIn);
        return result;
    }

    /**
     * Iris data CSV parser.
     *
     * @param filename Path to iris data csv file
     * @param separator A separator string used to split lines into tokens
     * @return Iris data parsed into a double[][] array
     */
    private double[][] parseCSV(final String filename, final String separator) {
        String line;
        String[] splitline;
        double[][] parsed = new double[irisRows][irisColumns];
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            // For now just prints line by line
            for (line = br.readLine(); i < irisRows;
                 line = br.readLine()) {
                // Split the line into tokens using the separator
                splitline = line.split(separator);
                /** Parse the measured values to string, then convert to double
                and insert to parsed output array. */
                String[] inputString = Arrays.copyOfRange(splitline, 0,
                                                          irisColumns - 1);
                for (int j = 0; j < inputString.length; j++) {
                    parsed[i][j] = Double.parseDouble(inputString[j]);
                }
                // Parse the flower name (String) into a number for neuralnet
                String flower = splitline[irisColumns - 1];
                switch (flower) {
                    case "Iris-setosa":
                        parsed[i][irisColumns - 1] = 0;
                        break;
                    case "Iris-versicolor":
                        parsed[i][irisColumns - 1] = 1;
                        break;
                    case "Iris-virginica":
                        parsed[i][irisColumns - 1] = 2;
                        break;
                    default:
                        throw new IllegalArgumentException(
                            "Invalid flower name" + flower);
                }
                i++;
            }
        } catch (IOException e) {
            // IO Exception includes errors if file not found, as well as
            // problems with reading a new line from the file
            System.out.println("File not found or can't read line");
        }
        return parsed;
    }

    /**
     * Shuffles the test data and splits into train and test data.
     * Uses the Fisher-Yates algorithm.
     *
     * @param data The data array to be shuffled and split
     * @return Shuffled data matrix
     */
    private double[][] shuffleData(final double[][] data) {
        Random rand = new Random();
        // Shuffle data
        for (int i = data.length - 1; i > 0; i--) {
            // Get a random integer j so that 0 <= j <= i
            int j = rand.nextInt(i + 1);
            // Swap indices i and j
            double[] temp = data[j];
            data[j] = data[i];
            data[i] = temp;
        }
        return data;
    }

    /**
     * Splits the shuffled data into training and testing inputs and outputs.
     *
     * @param data The data matrix
     */
    private void splitData(final double[][] data) {
        for (int i = 0; i < data.length; i++) {
            // Take the [testSize] first elements to train data
            // The rest will be testing.
            if (i < testSize) {
                for (int j = 0; j < data[i].length - 1; j++) {
                    trainIn[i][j] = data[i][j];
                }
                // Convert from int to binary form. E.g., 0 becomes 1 0 0,
                // 1 is 0 1 0 and so on.
                trainOut[i][(int) Math.round(data[i][data[i].length - 1])] =
                    1.0;
            } else {
                // Test data index (starts from zero)
                int k = i - testSize;
                for (int j = 0; j < data[i].length - 1; j++) {
                    testIn[k][j] = data[i][j];
                }
                testOut[k][(int) Math.round(data[i][data[i].length - 1])] =
                    1.0;
            }
        }
    }

    /**
     * The main method.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        String filename = "data/iris.data";
        IrisAnalysis iris = new IrisAnalysis(filename, ",");
        double[][] result = iris.classify();
        // Total classifications
        int total = 0;
        // Correct classifications
        int correct = 0;
        // Print the result and expected actual result from test data
        // Also calculate the percentage of correct calculations
        for (int i = 0; i < iris.testOut.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                // The actual classification result for current element
                int actual = (int) Math.round(result[i][j]);
                // The expected correct result
                int expected = (int) Math.round(iris.testOut[i][j]);
                // Check if actual classification matches the expected
                if (expected == 1) {
                    total++;
                    if (actual == 1) {
                        correct++;
                    }
                }
            }
        }
        System.out.println("Total classifications:");
        System.out.println(total);
        System.out.println("Correctly classified:");
        System.out.println(correct);
        System.out.println("Percentage of correct classifications:");
        System.out.println(100 * (double) correct / total);
    }
}

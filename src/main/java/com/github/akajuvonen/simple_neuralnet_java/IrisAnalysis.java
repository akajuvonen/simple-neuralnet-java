package com.github.akajuvonen.simple_neuralnet_java;

import com.github.akajuvonen.simple_neuralnet_java.NeuralNet;

/**
 * Iris data analysis class.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class IrisAnalysis {
    /**
     * Iris data analysis constructor.
     *
     * @param filename Path to iris data csv file
     */
    public IrisAnalysis(final String filename) {
        parseCSV(filename);
    }

    /**
     * Iris data CSV parser.
     *
     * @param filename Path to iris data csv file
     */
    private void parseCSV(final String filename) {
        //
    }

    /**
     * The main method.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        String filename = "data/iris.data";
        IrisAnalysis iris = new IrisAnalysis(filename);
    }
}

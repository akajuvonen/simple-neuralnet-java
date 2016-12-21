package com.github.akajuvonen.simple_neuralnet_java;

import com.github.akajuvonen.simple_neuralnet_java.NeuralNet;

/**
 * Iris data analysis class.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class IrisAnalysis {
    public IrisAnalysis(final String filename) {
        parseCSV(filename);
    }

    private void parseCSV(final String filename) {
        //
    }

    public static void main(final String[] args) {
        String filename = "data/iris.data";
        IrisAnalysis iris = new IrisAnalysis(filename);
    }
}

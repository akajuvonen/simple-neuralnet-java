package com.github.akajuvonen.simple_neuralnet_java;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;

/**
 * Iris data analysis class.
 *
 * @author Antti Juvonen
 * @version 0.3
 */
public class IrisAnalysis {
    /**
     * The separator used in CSV file splitting.
     */
    private String separator;
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
     * Iris data analysis constructor.
     *
     * @param filename Path to iris data csv file
     * @param separ A string character used to split csv line into tokens
     */
    public IrisAnalysis(final String filename, final String separ) {
        separator = separ;
        parseCSV(filename);
    }

    /**
     * Iris data CSV parser.
     *
     * @param filename Path to iris data csv file
     */
    private void parseCSV(final String filename) {
        String line;
        String[] splitline;
        double[][] parsed = new double[150][5];
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            // For now just prints line by line
            for (line = br.readLine(); i < 150;
                 line = br.readLine()) {
                System.out.println("Line: " + line);
                // Split the line into tokens using the separator
                splitline = line.split(separator);
                /** Parse the measured values to string, then convert to double
                and insert to parsed output array. */
                String[] inputString = Arrays.copyOfRange(splitline, 0, 4);
                for (int j = 0; j < inputString.length; j++) {
                    parsed[i][j] = Double.parseDouble(inputString[j]);
                }
                // Parse the flower name (String) into a number for neuralnet
                String flower = splitline[4];
                switch (flower) {
                    case "Iris-setosa":
                        parsed[i][4] = 0;
                        break;
                    case "Iris-versicolor":
                        parsed[i][4] = 1;
                        break;
                    case "Iris-virginica":
                        parsed[i][4] = 2;
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
    }

    /**
     * The main method.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        String filename = "data/iris.data";
        IrisAnalysis iris = new IrisAnalysis(filename, ",");
    }
}

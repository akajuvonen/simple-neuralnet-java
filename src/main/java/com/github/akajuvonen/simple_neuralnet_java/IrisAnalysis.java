package com.github.akajuvonen.simple_neuralnet_java;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

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
     * Iris data analysis constructor.
     *
     * @param filename Path to iris data csv file
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
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            // For now just prints line by line
            for (line = br.readLine(); line != null;
                 line = br.readLine()) {
                // Split the line into tokens using the separator
                splitline = line.split(separator);
                for (int i = 0; i < splitline.length; i++) {
                    System.out.println(splitline[i]);
                }
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

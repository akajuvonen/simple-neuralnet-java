package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.IOException;

/**
 * Unit tests for iris data analysis.
 *
 * @author Antti Juvonen
 * @version 0.5
 */
public class IrisAnalysisTest {
    /**
     * Test that iris analysis gives correct results.
     * Note that we do not not (can't) test private methods inside the class.
     */
    @Test
    public void testIrisAnalysis() {
        String filename = "data/iris.data";
        IrisAnalysis iris = new IrisAnalysis(filename, ",");
        double[][] result = iris.classify();
        // For some reason we have to call getter like this to get testOut
        double[][] testOut = iris.getTestOut();
        // Correct classifications
        int correctCount = 0;
        // Check how many classfications are correct
        for (int i = 0; i < testOut.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int expected = (int)Math.round(testOut[i][j]);
                int actual = (int)Math.round(result[i][j]);
                if (expected == actual) {
                    correctCount++;
                }
            }
        }
        System.out.println(correctCount);
    }
}

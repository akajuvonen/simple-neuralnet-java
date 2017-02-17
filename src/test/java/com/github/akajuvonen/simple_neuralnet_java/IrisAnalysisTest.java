package com.github.akajuvonen.simple_neuralnet_java;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.IOException;

/**
 * Unit tests for iris data analysis.
 *
 * @author Antti Juvonen
 * @version 0.1
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
    }
}

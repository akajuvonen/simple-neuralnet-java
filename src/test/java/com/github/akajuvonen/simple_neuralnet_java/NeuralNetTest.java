package com.github.akajuvonen.simple_neuralnet_java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for neural network.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class NeuralNetTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NeuralNetTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( NeuralNetTest.class );
    }

    /**
     * Neural net sanity test.
     */
    public void testNeuralNet()
    {
        // Create a new net
        NeuralNet net = new NeuralNet(4,10000);
        assertTrue( true );
    }
}

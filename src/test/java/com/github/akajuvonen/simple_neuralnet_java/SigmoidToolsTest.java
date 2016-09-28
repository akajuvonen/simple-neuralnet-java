package com.github.akajuvonen.simple_neuralnet_java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for sigmoid and derivative functions.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class SigmoidToolsTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SigmoidToolsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SigmoidToolsTest.class );
    }

    /**
     * Sigmoid function test
     */
    public void testSigmoid()
    {
        double i, result;
        // sigmoid(-10) should be close to zero
        i = -10.0;
        result = SigmoidTools.sigmoid(i);
        assertTrue(result < 0.1);
        // sigmoid(10) should be close to 1
        i = 10.0;
        result = SigmoidTools.sigmoid(i);
        assertTrue(result > 0.9);
        // sigmoid(0) should be 0.5
        i = 0.0;
        result = SigmoidTools.sigmoid(i);
        assertEquals(result, 0.5);
    }
}

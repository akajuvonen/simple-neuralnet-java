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
     * Neural net sanity test.
     */
    public void testSigmoid()
    {
        assertTrue( true );
    }
}

package com.github.akajuvonen.simple_neuralnet_java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for matrix operations library.
 *
 * @author Antti Juvonen
 * @version 0.1
 */
public class MatrixToolsTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MatrixToolsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MatrixToolsTest.class );
    }

    /**
     * TODO
     */
    public void testSomething()
    {
      assertTrue(true);
    }
}

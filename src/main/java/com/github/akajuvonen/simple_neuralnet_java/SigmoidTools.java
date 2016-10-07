package com.github.akajuvonen.simple_neuralnet_java;

/**
 * Sigmoid and sigmoid derivative functions. Mainly useful for neural networks.
 *
 * @author Antti Juvonen
 * @version 1.0
 */
final class SigmoidTools {
    /**
     * A private constructor for SigmoidTools.
     * This exists because java creates a public constructor
     * by default, which we don't want.
     */
    private SigmoidTools() {
        throw new AssertionError("Trying to instantiate a utility class");
    }

    /**
     * Sigmoid function. Returns 1 / (1+exp(-x)).
     *
     * @param x The input value
     * @return Sigmoid function result
     */
    static double sigmoid(final double x) {
        return 1 / (1 + Math.exp(-x));
    }

    /**
     * Sigmoid derivative function. x*(1-x).
     * The values should already be calculated using
     * the sigmoid method, i.e., the actual derivative
     * is sigmoid(x)*(1-sigmoid(x))
     *
     * @param x The input value
     * @return Sigmoid derivative function result
     */
    static double sigmoidDerivative(final double x) {
        return x * (1 - x);
    }
}

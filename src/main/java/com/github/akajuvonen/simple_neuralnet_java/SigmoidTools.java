package com.github.akajuvonen.simple_neuralnet_java;

/**
 * Sigmoid and sigmoid derivative functions. Mainly useful for neural networks.
 *
 * @author Antti Juvonen
 * @version 1.0
 */
public class SigmoidTools {
    /**
     * Sigmoid function. Returns 1 / (1+exp(-x)).
     *
     * @param x The input value
     * @return Sigmoid function result
     */
    public static double sigmoid(double x) {
        return 1/(1+Math.exp(-x));
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
    public static double sigmoidDerivative(double x) {
        return x*(1-x);
    }
}

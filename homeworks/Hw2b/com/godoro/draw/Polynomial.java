package com.godoro.draw;

public class Polynomial implements Function {

    private final double[] coefficients;

    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public double evaluate(double x) {
        double sum = 0;

        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, i);
        }
        return sum;
    }
}

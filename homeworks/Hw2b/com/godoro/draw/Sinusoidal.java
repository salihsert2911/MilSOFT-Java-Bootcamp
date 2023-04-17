package com.godoro.draw;

public class Sinusoidal implements Function {
    private final double a;
    private final double b;
    private final double c;

    public Sinusoidal(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double evaluate(double x) {
        return a * Math.sin(b * x + c);
    }
}

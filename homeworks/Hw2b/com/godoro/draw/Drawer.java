package com.godoro.draw;

public class Drawer {
    public void draw(Function f, double x1, double x2, int n) {
        double dx = (x2 - x1) / n;
        for (double x = x1; x < x2; x += dx) {
            double y = f.evaluate(x);
            System.out.println("X: " + x + "\tY: " + y);
        }
    }
}

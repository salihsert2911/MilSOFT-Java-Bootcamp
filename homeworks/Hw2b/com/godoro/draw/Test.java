package com.godoro.draw;

public class Test {
    public static void main(String[] args) {
        Drawer drawer = new Drawer();

        Function f1 = new Polynomial(-6, 5, 1);
        Function f2 = new Sinusoidal(10, 2, Math.PI / 6);

        drawer.draw(f1, 0, 2, 2);
        System.out.println("------------");
        drawer.draw(f2, 0, 2, 2);
    }
}

package com.jpeony.jvm.serial;

public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
                a = 1;
                x = b;
        });

        Thread other = new Thread(() -> {
                b = 1;
                y = a;
        });

        one.start();other.start();
        one.join();other.join();
        System.out.println("(" + x + "," + y + ")");
    }
}

package com.lanhuigu.io.stream;

import java.io.PrintWriter;

public class ChangeSystmeOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world!");
    }
}

package com.lanhuigu.java8;


public class Test {
    public static void main(String[] args) {
        String idNum = "52232419911208401X";
        if (idNum.contains("X") || idNum.contains("x")) {
            idNum = "****" + idNum.substring(idNum.length() - 4, idNum.length());
        }
    }
}

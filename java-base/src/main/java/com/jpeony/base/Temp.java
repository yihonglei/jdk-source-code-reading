package com.jpeony.base;

import java.io.File;

public class Temp {
    private static String kvConfigPath = System.getProperty("user.home") + File.separator + "namesrv" + File.separator + "kvConfig.json";
    public static void main(String[] args) {
        System.out.println(kvConfigPath);
    }
}

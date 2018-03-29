package com.lanhuigu.others.properties;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ShowProperties
 * @Package: com.lanhuigu.others.properties
 * @date 2018/3/22 9:31
 */
public class ShowProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}

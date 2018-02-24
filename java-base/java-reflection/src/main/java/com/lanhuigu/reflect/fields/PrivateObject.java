package com.lanhuigu.reflect.fields;

/**
 * 定义一个反射访问私有变量和私有方法的对象
 */
public class PrivateObject {
    private String privateString = null;

    /**
     * 有参构造器
     * @param privateString
     */
    public PrivateObject(String privateString) {
        this.privateString = privateString;
    }

    /**
     * 私有方法
     * @return String
     */
    private String getPrivateString() {
        return this.privateString;
    }
}

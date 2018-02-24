package com.lanhuigu.reflect.cls;

import com.lanhuigu.reflect.annotations.MyAnnotation;

@MyAnnotation(name = "testAnnoation", value = "hello world")
public class MyObject {
    /** 公有变量*/
    public static final String testFieldName = "test-field-name";
    /** 私有变量 */
    private String username;
    private int age;

    public MyObject () {
        username = "Test1-Class";
        age = 27;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

package com.lanhuigu.reflect.common;

public class MyObject {
    /** 公开成员变量 */
    public String fieldName = "Test-Field-Name";
    /** 私有属性 */
    private String userName;
    private String password;

    /** 构造器 */
    public MyObject() {

    }

    public MyObject(String userName) {
        this.userName = userName;
    }

    public MyObject(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    /** methods */
    public String doSomething(String something) {
        return "Hello World-" + something;
    }

    /** getter and setter methods */
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

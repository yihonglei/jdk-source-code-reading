package com.jpeony.jvm.optimize;

import java.lang.reflect.Method;

/**
 * 【程序运行过程中避免使用反射】
 * <p>
 * 反射是Java提供给用户一个很强大的功能，功能强大往往意味着效率不高。
 * 不建议在程序运行过程中使用尤其是频繁使用反射机制，特别是Method的invoke方法，
 * 如果确实有必要，一种建议性的做法是将那些需要通过反射加载的类在项目启动的时候通过反射实例化出一个对象并放入内存，
 * 用户只关心和对端交互的时候获取最快的响应速度，并不关心对端的项目启动花多久时间。
 * <p>
 * 【反射优缺点】
 * 优点：
 * 1）能够运行时动态获取类的实例，大大提高系统的灵活性和扩展性。
 * 2）与Java动态编译相结合，可以实现无比强大的功能
 * 缺点：
 * 1）使用反射的性能较低
 * 2）使用反射相对来说不安全
 * 3）破坏了类的封装性，可以通过反射获取这个类的私有方法和属性
 *
 * @author yihongeli
 */
public class Optimize08 {

    public static void main(String[] args) {
        // 获取Class对象
        Class myClass = MyObject.class;

        // 获取公开(public)方法集合
        Method[] methods = myClass.getMethods();

        // 循环打印方法名
        for (Method method : methods) {
            System.out.println("方法名:" + method.getName());
        }
    }
}


class MyObject {
    /**
     * 公开成员变量
     */
    private String fieldName = "Test-Field-Name";
    /**
     * 私有属性
     */
    private String userName;
    private String password;

    /**
     * 构造器
     */
    public MyObject() {

    }

    public MyObject(String userName) {
        this.userName = userName;
    }

    public MyObject(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * methods
     */
    public String doSomething(String something) {
        return "Hello World-" + something;
    }

    /**
     * getter and setter methods
     */
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
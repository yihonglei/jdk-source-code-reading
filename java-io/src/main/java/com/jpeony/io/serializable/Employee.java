package com.jpeony.io.serializable;

import java.io.Serializable;

/**
 * 实现序列化接口--Serializable
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 8182014220967586096L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * 年龄
     */
    private transient int age;
    /**
     * 编号
     */
    private int number;

    public Employee() {

    }

    public Employee(String name, String address, int age, int number) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }
}

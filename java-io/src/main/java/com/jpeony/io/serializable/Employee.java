package com.jpeony.io.serializable;

import java.io.Serializable;

/**
 * 实现序列化接口--Serializable
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 8182014220967586096L;
    /** 姓名 */
    public String name;
    /** 地址 */
    public String address;
    /** 年龄 */
    public transient int age;
    /** 编号 */
    public int number;
}

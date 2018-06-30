package com.lanhuigu.java.annotation.demo2;

/**
 * 实体类
 */
public class User {
    @FieldMeta(id=true, name="序列号", order=1)
    private int id;
    @FieldMeta(name="姓名", order=3)
    private String name;
    @FieldMeta(name="年龄", order=2)
    private int age;

    @FieldMeta(description="描述描述描述", order=4)
    public String desc() {
        return "java反射获取annotation的测试";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

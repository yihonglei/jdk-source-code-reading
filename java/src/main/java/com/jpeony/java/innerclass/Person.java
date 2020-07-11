package com.jpeony.java.innerclass;

/**
 * 创建一个内部类Person,其中包含Teacher,Student两个内部类
 */
public class Person {
    /**
     * inner class one
     */
    class Teacher {
        public void eat() {
            System.out.println("Teacher eat!");
        }
    }

    /**
     * inner class two
     */
    class Student {
        public void eat() {
            System.out.println("Student eat!");
        }
    }

    /**
     * outer class method
     */
    public void con() {
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.eat();
        student.eat();
    }

    /**
     * 提供一个供外部类获取内部类对象的方法
     */
    public Teacher getTeacher() {
        return new Teacher();
    }

    /**
     * test code
     */
    public static void main(String[] args) {
        Person person = new Person();
        person.con();
        // 在静态方法中不能直接new非静态的内部类，没有权限
        //Teacher teacher = new Teacher();// 直接new将报错
        // 可以通过外部类提供的获取内部类对象的方法获取内部类对象
        Teacher teacher = person.getTeacher();
        teacher.eat();
    }

}

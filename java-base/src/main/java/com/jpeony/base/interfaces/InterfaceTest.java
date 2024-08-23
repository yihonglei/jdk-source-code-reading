package com.jpeony.base.interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();

        System.out.println(teacher.eat());
        System.out.println(teacher.sleep());
        System.out.println("============");
        System.out.println(student.eat());
        System.out.println(student.sleep());

    }
}

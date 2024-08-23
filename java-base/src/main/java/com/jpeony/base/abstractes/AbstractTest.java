package com.jpeony.base.abstractes;

public class AbstractTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student();

        //OthersPerson othersPerson = new OthersPerson();//报错，抽象类不能被实例化

        System.out.println(teacher.eat());
        System.out.println(teacher.sleep());
        // 继承父类非抽象方法
        System.out.println(teacher.sport());

        System.out.println("==============");
        System.out.println(student.eat());
        System.out.println(student.sleep());
        // 继承父类非抽象方法
        System.out.println(student.sport());
    }
}

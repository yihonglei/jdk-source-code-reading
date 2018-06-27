package com.lanhuigu.staticdemo;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: StaticInitialization
 * @Package: com.lanhuigu.staticdemo
 * @date 2018/6/23 22:36
 */
public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Creating new School() in main");
        new School();
        System.out.println("Creating new School() in main");
        teacher.f2(1);
        school.f3(1);
    }
    static Teacher teacher = new Teacher();
    static School school = new School();
}

class Student {
    Student(int marker) {
        System.out.println("Student(" + marker +")");
    }

    void f1(int marker) {
        System.out.println("f1("+ marker +")");
    }
}

class Teacher {
    static Student s1 = new Student(1);

    Teacher() {
        System.out.println("Teacher()");
        s2.f1(1);
    }
    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Student s2 = new Student(2);
}


class School {
    Student s3 = new Student(3);
    static Student s4 = new Student(4);
    School() {
        System.out.println("School()");
        s4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3("+ marker +")");
    }
    static Student s5 = new Student(5);
}
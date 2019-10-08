package com.lanhuigu.java.innerclass;

public class PersonTwo {
    /**
     * inner class one
     */
    public class Teacher {
        private int j = 1;

        public void eat() {
            System.out.println("Teacher eat!");
        }
    }

    /**
     * inner class two 实现TestInnerInterface接口
     */
    public class Student implements InnerInterfaceTest {
        public void eat() {
            System.out.println("Student eat!");
        }

        @Override
        public void call() {
            System.out.println("Student call!");
        }
    }

    public static void main(String[] args) {
        // 可以通过外部类PersonTwo.new 的方式使用内部类
        PersonTwo personTwo = new PersonTwo();
        PersonTwo.Teacher teacher = personTwo.new Teacher();
        teacher.eat();

        PersonTwo.Student student = personTwo.new Student();
        student.eat();
        student.call();
    }
}

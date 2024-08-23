package com.jpeony.base.innerclass;

public class PersonThree {
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
        // 可以通过外部类PersonThree.new 的方式使用内部类
        PersonThree personThree = new PersonThree();
        PersonThree.Teacher teacher = personThree.new Teacher();
        teacher.eat();

        PersonThree.Student student = personThree.new Student();
        student.eat();
        student.call();
    }
}

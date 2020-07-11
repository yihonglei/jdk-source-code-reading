package com.jpeony.java.annotation.demo1;

public class AnnotationTest {
    @MyAnnotation(value1 = "添加变量", value2 = MyEnum.Sunny, value3 = {"a", "b"})
    public void execute() {
        System.out.println("method");
    }
}

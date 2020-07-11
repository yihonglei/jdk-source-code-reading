package com.jpeony.jvm.optimize;

/**
 * 【将常量声明为static final，并以大写命名】
 * 这样在编译期间就可以把这些内容放入常量池中，避免运行期间计算生成常量的值。
 * 另外，将常量的名字以大写命名也可以方便区分出常量与变量;
 */
public class Optimize06 {
    public static final String DEFAULT_USER_NAME = "default name";

    public static void main(String[] args) {
        System.out.println(Optimize06.DEFAULT_USER_NAME);
    }
}

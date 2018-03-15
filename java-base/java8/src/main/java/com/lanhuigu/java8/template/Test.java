package com.lanhuigu.java8.template;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.template
 * @date 2018/3/12 16:01
 */
public class Test {
    public static void main(String[] args) {
        AbstractTemplate template = new ConcreteTemplate();
        template.update();
    }
}

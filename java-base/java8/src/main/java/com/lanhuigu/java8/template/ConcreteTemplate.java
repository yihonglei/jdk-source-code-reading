package com.lanhuigu.java8.template;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.template
 * @date 2018/3/12 16:00
 */
public class ConcreteTemplate extends AbstractTemplate {
    @Override
    public void print() {
        System.out.println("子类实现打印方法");
    }
}

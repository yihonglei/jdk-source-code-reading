package com.lanhuigu.java8.template;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.template
 * @date 2018/3/12 15:55
 */
public abstract class AbstractTemplate {
    public void update() {
        System.out.println(getHello());
        System.out.println("******begin******");
        for (int i = 0; i < 10; i++) {
            print();
        }
        System.out.println("******end******");
    }

    private String getHello() {
        return "算法的公共实现部分!";
    }

    /**
     * 子类中实现
     */
    public abstract  void print();
}

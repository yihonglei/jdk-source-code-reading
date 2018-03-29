package com.lanhuigu.others.statics;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: IncrementableTest
 * @Package: com.lanhuigu.others.statics
 * @date 2018/3/22 9:01
 */
public class IncrementableTest {
    public static void main(String[] args) {
        /** 不能通过类实例访问静态成员 */
        /*Incrementable incrementable = new Incrementable();
        incrementable.increment();*/

        /** 通过类直接访问静态成员 */
        System.out.println(Incrementable.increment());
    }
}

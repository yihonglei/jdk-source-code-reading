package com.lanhuigu.java.interfacedemo;

/**
 * 定义接口person，其中的方法均为public权限，
 * 方法可以有返回值，也可以没有返回值，但是都没有具体实现；
 * 不允许出现call这种自实现方法，否则编译不通过，除非用java8的default关键字，定义默认实现；
 */
public interface Person {

    public String eat();

    public String sleep();

	/*public String call() {
		return "打电话";
	}*/

    default public String hello() {
        return "java8默认实现，实现类可以选择是否实现该方法";
    }
}

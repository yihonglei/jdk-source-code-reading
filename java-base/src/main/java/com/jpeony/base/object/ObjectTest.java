package com.jpeony.base.object;

/**
 * 1）equals描述的是一种等价关系，不仅仅是引用相等
 * 2）equals重写需要满足自反性、对称性、传递性和非空性
 * 3）hashCode返回对象的哈希值，多次调用hashCode返回值不变
 * 4）hashCode不一定与内存地址相关
 * 5）hashCode会发生碰撞
 * 6）hashCode与equals密切相关
 * equals返回true的两个实例，hashCode值必须一样；
 * hashCode值一样的两个实例，其equals方法返回不一定为true（可能有哈希碰撞等因素）；
 */
public class ObjectTest {
    public static void main(String[] args) {
//        Object;
    }
}

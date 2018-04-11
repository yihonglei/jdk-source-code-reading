package com.lanhuigu.thread.demo5;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: MySharedObject
 * @Package: com.lanhuigu.thread.demo5
 * @date 2018/4/10 21:14
 */
public class MySharedObject {
    public static final MySharedObject sharedInstance = new MySharedObject();

    //member variables pointing to two objects on the heap

    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    public long member1 = 12345;
    public long member2 = 67890;
}

package com.jpeony.jvm.optimize;

/**
 * 【尽量重用对象，尽量少new对象】
 * 特别是String对象的使用，出现字符串连接时应该使用StringBuilder/StringBuffer代替。
 * 由于Java虚拟机不仅要花时间生成对象，以后可能还需要花时间对这些对象进行垃圾回收和处理，
 * 因此，生成过多的对象将会给程序的性能带来很大的影响。
 */
public class Optimize01 {
    public static void main(String[] args) {
        /*
         * String Test
                * String在java中是不可变长的,一旦初始化就不能修改长度，简单的字符串拼接其实是创建新的String对象，再把拼接后的内容赋值给新的对象，
         * 在频繁修改的情况下会频繁创建对象;
         */
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            str += i;
        }
        System.out.println("String耗时:" + (System.currentTimeMillis() - start));

        /*
         * StringBuilder Test
                * 而StringBuilder则不会,从头到尾只有一个实例对象，咋弄的？
         * 其实StringBuilder在append时并不是用String存储，而是放到一个value的char数组中，
         * 字符串是固定长度的，而数组是可以扩容的，这样就不需要不停创建对象了。
         */
        StringBuilder sb = new StringBuilder();
        long startSb = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
        System.out.println("StringBuilder耗时:" + (System.currentTimeMillis() - startSb));
    }
}

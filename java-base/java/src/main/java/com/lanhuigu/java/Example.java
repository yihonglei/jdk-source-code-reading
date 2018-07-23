package com.lanhuigu.java;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Example
 * @Package: com.lanhuigu.java
 * @date 2018/7/18 17:06
 */
public class Example{
    String str = new String("good");
    char[ ] ch = { 'a' , 'b' , 'c' };
    public static void main(String args[]){
        Example ex = new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }
}

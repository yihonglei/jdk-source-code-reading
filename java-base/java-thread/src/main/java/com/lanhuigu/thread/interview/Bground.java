package com.lanhuigu.thread.interview;

/**
 * @author yihonglei
 * @date 2019/2/12 18:10
 */
public class Bground extends Thread {

    public static void main(String argv[]){
        Bground b = new Bground();
        b.run();
    }

    public void start(){
        for(int i=0;i<10;i++){
            System.out.println("Value of i = "+i);
        }
    }
}

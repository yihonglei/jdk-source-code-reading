package com.lanhuigu.java.print;

/**
 * @author yihonglei
 * @date 2019/11/22 10:55 AM
 */
public class PrintTest {
    static boolean out(char c){
        System.out.println(c);
        return true;
    }
    public static void main(String[] argv){
        int i = 0;
        for(out('A');out('B') && (i<2);out('C')){
            i++;
            out('D');
        }
    }
}

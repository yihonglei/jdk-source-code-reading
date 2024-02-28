package com.jpeony.base.print;

/**
 * @author yihonglei
 */
public class PrintTest {
    static boolean out(char c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] argv) {
        int i = 0;
        for (out('A'); out('B') && (i < 2); out('C')) {
            i++;
            out('D');
        }
    }
}

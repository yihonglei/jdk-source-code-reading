package com.lanhuigu.others.liuc;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: TernaryIFElse
 * @Package: com.lanhuigu.others.liuc
 * @date 2018/3/27 9:31
 */
public class TernaryIFElse {
    public static void main(String[] args) {
        System.out.println(ternary(9));
        System.out.println(ternary(10));
        System.out.println(standardIfElse(9));
        System.out.println(standardIfElse(10));
    }

    public static int ternary(int i) {
        return  i < 10 ? i * 100 : i * 10;
    }

    public static int standardIfElse(int i) {
        if (i < 10) {
            return i * 100;
        } else {
            return i * 10;
        }
    }
}

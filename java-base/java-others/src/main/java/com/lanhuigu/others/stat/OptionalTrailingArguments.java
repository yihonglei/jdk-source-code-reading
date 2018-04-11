package com.lanhuigu.others.stat;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: OptionalTrailingArguments
 * @Package: com.lanhuigu.others.stat
 * @date 2018/4/9 11:24
 */
public class OptionalTrailingArguments {
    static void f(int required, String... trailing) {
        System.out.print("required: " + required + " ");
        for(String s : trailing) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        f(1, "one");
        f(2, "two", "three");
        f(0);
    }
}

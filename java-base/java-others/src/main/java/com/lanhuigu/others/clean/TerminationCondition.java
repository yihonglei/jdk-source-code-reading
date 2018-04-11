package com.lanhuigu.others.clean;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: TerminationCondition
 * @Package: com.lanhuigu.others.clean
 * @date 2018/3/30 15:18
 */
public class TerminationCondition {
    static class Book {
        boolean checkOut = false;
        Book (boolean checkOut) {
            this.checkOut = checkOut;
        }

        void checkIn() {
            checkOut = false;
        }
        @Override
        protected void finalize() {
            if (checkOut) {
                System.out.println("Error: checked out");
            }
        }
    }

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }

}

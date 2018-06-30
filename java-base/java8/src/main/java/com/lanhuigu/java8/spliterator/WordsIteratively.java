package com.lanhuigu.java8.spliterator;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: WordsIteratively
 * @Package: com.lanhuigu.java8.spliterator
 * @date 2018/6/29 10:08
 */
public class WordsIteratively {

    public int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter ++;
                }
                lastSpace = true;
            }
        }

        return counter;
    }

}

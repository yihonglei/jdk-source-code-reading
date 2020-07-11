package com.jpeony.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Java正则表达式：
 * matches()、replaceAll()、replaceFirst()、split()；
 *
 * @author yihonglei
 */
public class RegexTest {
    public static void main(String[] args) {
        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}

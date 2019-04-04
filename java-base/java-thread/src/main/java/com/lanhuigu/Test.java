package com.lanhuigu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yihonglei
 * @date 2019/4/4 18:32
 */
public class Test {
    public static void main(String[] args) {
        // 字典
        Map<Integer, Integer> effectDays = new HashMap<>();
        effectDays.put(1, 30);
        effectDays.put(2, 90);
        effectDays.put(3, 180);
        effectDays.put(4, 12);
        effectDays.put(5, 23);
        effectDays.put(6, 45);
        effectDays.put(7, 36);

        System.out.println(effectDays.get(1));
    }
}

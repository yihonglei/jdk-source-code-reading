package com.lanhuigu.java8.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.optional
 * @date 2018/3/15 14:02
 */
public class Test1 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Object value = map.get("key");

        Optional<Object> optValue = Optional.ofNullable(value);

    }
}

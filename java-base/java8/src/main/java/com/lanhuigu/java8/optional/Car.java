package com.lanhuigu.java8.optional;

import java.util.Optional;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.nullpointer
 * @date 2018/3/15 10:54
 */
public class Car {
    private Optional<Insurance> insurance;
    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

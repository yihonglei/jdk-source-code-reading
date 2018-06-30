package com.lanhuigu.java8.optional;

import java.util.Optional;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Car
 * @Package: com.lanhuigu.java8.optional
 * @date 2018/6/29 14:29
 */
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

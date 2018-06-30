package com.lanhuigu.java8.optional;

import javax.swing.*;
import java.util.Optional;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Person
 * @Package: com.lanhuigu.java8.optional
 * @date 2018/6/29 14:12
 */
public class Person {
    private Optional<Car> car;
    private Optional<Car> getCar() {
        return car;
    }
}

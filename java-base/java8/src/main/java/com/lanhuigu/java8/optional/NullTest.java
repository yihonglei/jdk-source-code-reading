package com.lanhuigu.java8.optional;

import java.util.Optional;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.nullpointer
 * @date 2018/3/15 11:01
 */
public class NullTest {
    public static void main(String[] args) {
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        System.out.println(getCarInsuranceName(optPerson));
    }

    public static String getCarInsuranceName(Optional<Person> optPerson) {
        /** 流的扁平化处理 */
       return optPerson.flatMap(Person::getCar)
               .flatMap(Car::getInsurance)
               .map(Insurance::getName)
               .orElse("Unknown");
    }
}

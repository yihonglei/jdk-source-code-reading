package com.lanhuigu.java8.nullpointer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.nullpointer
 * @date 2018/3/15 11:50
 */
public class CreateOptionalTest {
    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty();
        Optional<Car> optCar2 = Optional.of(new Car());
        Optional<Car> optCar3 = Optional.ofNullable(new Car());

        Map maps = new HashMap<String, Object>();
        maps.put("hhh", "123");
        BigDecimal bigDecimal = new BigDecimal(Optional.ofNullable(maps.get("hhh")).orElse("-1").toString());

        System.out.println(bigDecimal);

        Insurance insurance = new Insurance();
        insurance.setName("This my test!");
        Optional<Insurance> optInsurance = Optional.ofNullable(new Insurance());
        Optional<String> name = optInsurance.map(Insurance::getName);

    }
}

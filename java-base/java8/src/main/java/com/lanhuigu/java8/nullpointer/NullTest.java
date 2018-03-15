package com.lanhuigu.java8.nullpointer;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.nullpointer
 * @date 2018/3/15 11:01
 */
public class NullTest {
    public static void main(String[] args) {
        System.out.println(getCarInsuranceName(new Person()));
    }

    public static String getCarInsuranceName(Person person) {
        /** 多层嵌套循环进行null值判断 */
        /*if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }*/

        if (person == null) {
            return "UnKnown";
        }

        Car car = person.getCar();
        if (car == null) {
            return "UnKnown";
        }

        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "UnKnown";
        }

        return insurance.getName();
    }
}

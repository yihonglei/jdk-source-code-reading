package com.lanhuigu.java8.sort;

import java.util.Date;

/**
 * @author yihonglei
 */
public class Person {
    private String name;
    private Integer age;
    private Date bookingDate;

    public Person(String name, Integer age, Date bookingDate) {
        this.name = name;
        this.age = age;
        this.bookingDate = bookingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}

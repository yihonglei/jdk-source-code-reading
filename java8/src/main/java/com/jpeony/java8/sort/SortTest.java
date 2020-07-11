package com.jpeony.java8.sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihonglei
 */
public class SortTest {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Person p1 = new Person("one", 1, sdf.parse("2019-12-01 11:23:34"));
        Person p2 = new Person("two", 2, sdf.parse("2019-12-02 11:23:34"));
        Person p3 = new Person("three", 3, sdf.parse("2019-12-03 11:23:34"));
        Person p4 = new Person("four", 4, sdf.parse("2019-12-04 11:23:34"));
        Person p5 = new Person("five", 5,sdf.parse("2019-12-05 11:23:34"));

        List<Person> personList = new ArrayList<Person>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        Date bookingDate = sdf.parse("2019-11-03 11:23:34");

        //java8遍历
//        personList.forEach(p -> System.out.println(p.getBookingDate()));
        //按照person的 age进行排序
        //方法一
//        personList.sort((o1, o2) -> o1.getBookingDate().compareTo(o2.getBookingDate())); //正序
//        personList.sort((o1, o2) -> o2.getBookingDate().compareTo(o1.getBookingDate())); //倒序
        //方法二
//         personList.sort(Comparator.comparing(Person::getBookingDate)); // 正序
//         personList.sort(Comparator.comparing(Person::getBookingDate).reversed()); // 倒序
        //遍历
//        personList.forEach(p -> System.out.println(p.getBookingDate()));

//        System.out.println("========================================");

        //获取bookingDate最大的Person
//        Person maxAgePerson = personList.stream().max(Comparator.comparing(Person::getBookingDate)).get();
//        System.out.println(maxAgePerson.getBookingDate());

//        System.out.println("========================================");

        //获取bookingDate最小的Person
//        Person minAgePerson = personList.stream().min(Comparator.comparing(Person::getBookingDate)).get();
//        System.out.println(minAgePerson.getBookingDate());

        //过滤出getBookingDate超过多少的的person，想过滤出什么条件的都可以
        List<Person> personList1 = personList.stream().filter(person -> person.getBookingDate().before(bookingDate))
                .collect(Collectors.toList());
        Person ppp = personList.stream().filter(person -> person.getBookingDate().before(bookingDate)).max(Comparator.comparing(Person::getBookingDate)).orElse(null);
        personList1.forEach(p -> System.out.println(p.getBookingDate()));
        System.out.println(ppp);


        List<Person> personList2 = personList.stream().filter(person -> person.getBookingDate().after(bookingDate))
                .collect(Collectors.toList());
        Person ppp2 = personList.stream().filter(person -> person.getBookingDate().after(bookingDate)).min(Comparator.comparing(Person::getBookingDate)).orElse(null);
        personList2.forEach(p -> System.out.println(p.getBookingDate()));
        System.out.println(ppp2.getBookingDate());

        //统计出年龄等于20的个数
//        long count = personList.stream().filter(person -> person.getAge() == 20).count();

        //获得年龄的平均值
//        double asDouble = personList.stream().mapToInt(person -> person.getAge()).average().getAsDouble();

        //获得年龄的求和
//        int sum = personList.stream().mapToInt(person -> person.getAge()).sum();

    }
}

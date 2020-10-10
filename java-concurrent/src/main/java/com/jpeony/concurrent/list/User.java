package com.jpeony.concurrent.list;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yihonglei
 */
@Data
public class User implements Comparable<User> {
    private int age;


    @Override
    public int compareTo(User o) {
        int i = this.age - o.age;
        if (i > 0) {
            return 1;
        }
        if (i < 0) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setAge(20);

        User user2 = new User();
        user2.setAge(18);

        list.add(user1);
        list.add(user2);
        System.out.println("listA=" + list);

        // 正序
        Collections.sort(list);
        System.out.println("listB=" + list);

        // 倒序
        Collections.reverse(list);
        System.out.println("listC=" + list);
    }
}

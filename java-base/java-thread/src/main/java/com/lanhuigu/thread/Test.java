package com.lanhuigu.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yihonglei
 * @date 2018/8/23 17:09
 */
public class Test {
    public static void main(String[] args) {
        test();
    }


    public static void test() {
        /** 基础数据 */
        List<User> businessList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            User user = new User();
            user.setUsername("UserName" + i);
            user.setPassword("Password" + i);

            businessList.add(user);
        }

        /** 要移除数据加入tmpList */
        List<User> tmpList = new ArrayList<>();
        for (int j = 0; j < businessList.size(); j++ ) {
            if (j == 2 || j == 5) {
                tmpList.add(businessList.get(j));
            }
        }

        /** 将tmpList从businessList中移除 */
        if (tmpList.size() > 0) {
            tmpList.forEach(tmpObj -> {
                businessList.remove(tmpObj);
            });
        }

        /** 打印最新的businessList */
        businessList.forEach(busObj -> {
            System.out.println(busObj);
        });
    }

    private static class User {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}

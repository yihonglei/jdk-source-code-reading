package com.lanhuigu.thread.waitnotify.general;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yihonglei
 *  2019/2/15 11:17
 */
public class MyList {
    private List<String> list = new ArrayList<String>();

    public void addUserName(String username) {
        list.add(username);
    }

    public int size() {
        return list.size();
    }
}

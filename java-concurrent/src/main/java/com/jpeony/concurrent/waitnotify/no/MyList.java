package com.jpeony.concurrent.waitnotify.no;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yihonglei
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

package com.lanhuigu.reflect.loadclass;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public List<String> stringList = new ArrayList<>();

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> list) {
        this.stringList = list;
    }
}

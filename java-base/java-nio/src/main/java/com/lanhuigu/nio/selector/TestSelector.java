package com.lanhuigu.nio.selector;

import java.io.IOException;
import java.nio.channels.Selector;

public class TestSelector {
    public static void main(String[] args) {
        try {
            // 创建Selector
            Selector selector = Selector.open();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

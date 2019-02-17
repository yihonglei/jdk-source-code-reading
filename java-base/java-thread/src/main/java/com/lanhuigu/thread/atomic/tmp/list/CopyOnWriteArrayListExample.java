package com.jiagouedu.list;/*
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　永无BUG 　┣┓
 * 　　　　┃　　如来保佑　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
  public static void main(String[] args) throws InterruptedException {
    final List<Integer> list = new CopyOnWriteArrayList<Integer>();

    // 线程A将0-1000添加到list
    new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 1000 ; i++) {
          list.add(i);
        }
      }
    }).start();

    // 线程B将1000-2000添加到列表
    new Thread(new Runnable() {
      public void run() {
        for (int i = 1000; i < 2000 ; i++) {
          list.add(i);
        }
      }
    }).start();

    Thread.sleep(1000);

    // 打印所有结果
    for (int i = 0; i < list.size(); i++) {
      System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
    }
  }
}

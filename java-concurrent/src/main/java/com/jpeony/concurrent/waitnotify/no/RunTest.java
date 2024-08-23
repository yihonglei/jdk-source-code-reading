package com.jpeony.concurrent.waitnotify.no;

/**
 * 不使用等待/通知模式，通过sleep和while配合实现线程间的通信;
 * A线程不断添加元素，B线程while循环一直检查共享的list，
 * B线程可以根据list做各种判断和处理，从而实现A线程与B线程之间的通信!
 * 即两个线程通过读写一个共享变量来完成线程通信。
 * <p>
 * 这种处理方式的缺点:
 * (1) B线程一直通过某个条件轮询，浪费cpu资源；
 * (2) B线程轮询时间大小，对轮询条件也有影响，渠道的轮询条件有可能出现"错过精准条件"
 * 比如,如果B线程判断改为myList.size() == 5，则可能出现A线程添加到5的时候，
 * B线程没有轮询到，当B线程执行到myList.size()的时候，可能取到的值为6,
 * 哪么就会出现，B线程错过了与A线程精准对接的条件，导致B线程与A线程错过了通信的机会
 */
public class RunTest {
    public static void main(String[] args) {
        MyList myList = new MyList();

        ThreadA threadA = new ThreadA(myList);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(myList);
        threadB.setName("B");
        threadB.start();
    }
}


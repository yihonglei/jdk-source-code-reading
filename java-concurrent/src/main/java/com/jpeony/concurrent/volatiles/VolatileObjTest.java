package com.jpeony.concurrent.volatiles;

/**
 * @author yihonglei
 */
public class VolatileObjTest {
    public static void main(String[] args) throws InterruptedException {
        VolatileObj obj1 = new VolatileObj();
        obj1.setVolatile_i(100);

        Thread.sleep(500);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                VolatileObj obj2 = new VolatileObj();
                obj2.setVolatile_i(200);
                System.out.println("-----");
            }
        });
        t1.start();

        Thread.sleep(1000);
        System.out.println(obj1.getVolatile_i());
    }
}

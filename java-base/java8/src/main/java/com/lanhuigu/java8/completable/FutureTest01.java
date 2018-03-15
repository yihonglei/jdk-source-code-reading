package com.lanhuigu.java8.completable;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.completable
 * @date 2018/3/15 15:02
 */
public class FutureTest01 {
    // create thread pool
    private static final ExecutorService executorService = newCachedThreadPool();

    public static void main(String[] args) {
        // put task into thread pool
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomeLongCmputation();
            }

            private Double doSomeLongCmputation() {
                return new Double(2);
            }
        });

        try {
            // execute task
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println("This my double:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        // shutdown now thread pool
        executorService.shutdownNow();
    }

}

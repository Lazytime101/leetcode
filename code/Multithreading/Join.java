package Multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Join {
    public void run() throws Exception {
        long start = System.currentTimeMillis();
        for (int j = 0; j < 10; j++) {
            Thread T1 = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("hi");
                }
            });
            T1.start();
            System.out.println(" t1 start");
            Thread T2 = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("jack");
                }
            });
            T2.start();
            System.out.println(" t2 start");
            // 等待T1、T2结束
            T1.join();
            T2.join();
            // 执行对账操作
            System.out.println("join finis");            // 差异写入差异库
        }
        long end = System.currentTimeMillis();
        System.out.println("run 时间"+(end-start)+"ms");


    }

    public  void  runnew() throws Exception{
        long start = System.currentTimeMillis();
        Executor executor = Executors.newFixedThreadPool(2);
        for (int j = 0; j < 10; j++) {
            CountDownLatch latch = new CountDownLatch(2);
            executor.execute(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("hi");
                }
                latch.countDown();
            });
            System.out.println(" t1 start");
            executor.execute(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("jack");
                }
                latch.countDown();

            });
            System.out.println(" t2 start");
            // 等待T1、T2结束
            latch.await();
            // 执行对账操作
            System.out.println("join finis");            // 差异写入差异库
        }
        long end = System.currentTimeMillis();

        System.out.println("run new 时间"+(end-start)+"ms");


    }


    public static void main(String[] args) throws Exception {
        Join join = new Join();
        join.runnew();
    }


}

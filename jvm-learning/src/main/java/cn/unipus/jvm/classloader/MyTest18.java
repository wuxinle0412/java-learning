package cn.unipus.jvm.classloader;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/26 16:40
 */
public class MyTest18 {
  public static void main(String[] args) throws Exception {
    ExecutorService es = Executors.newSingleThreadExecutor();
    System.out.println("time: " + new Date());
    Callable<Integer> task = new Callable<Integer>() {
      public Integer call() throws Exception {
        Thread.currentThread().sleep(10000);

        return 10;
      }
    };

    Future<Integer> result = es.submit(task);
    Integer printNumber = result.get();
    System.out.println("time: " + new Date() + ", result: " + printNumber);
    es.shutdown();
    Thread.sleep(10000);

    System.out.println("end: " + new Date());
  }
}

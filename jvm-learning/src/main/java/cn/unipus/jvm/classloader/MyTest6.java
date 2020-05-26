package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/17 20:05
 */
/*
*   类在准备阶段，从上往下为类的静态变量赋初始值。
* */
public class MyTest6 {
  public static void main(String[] args) {
    Singleton singleton1 = Singleton.getInstance();

    System.out.println("counter1:" + Singleton.counter1);
    System.out.println("counter2:" + Singleton.counter2);
  }
}

class Singleton {
  public static int counter1;

  private static Singleton singleton = new Singleton();
  private Singleton() {
    counter1++;
    counter2++;
  }

  public static int counter2 = 0;  //先初始化singleton对象，在初始化counter2变量。

  public static Singleton getInstance() {
    return singleton;
  }
}

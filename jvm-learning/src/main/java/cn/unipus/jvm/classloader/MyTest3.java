package cn.unipus.jvm.classloader;

import java.util.UUID;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/17 18:34
 */

/*
*  当一个常量的值并非编译期可以确定的，那么其值就不会被放到调用类的常量池中。
*  这时只有程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化。
*
* */
public class MyTest3 {
  public static void main(String[] args) {
    System.out.println(MyParent3.str);
  }
}

class MyParent3 {
  public static final String str = UUID.randomUUID().toString();

  static {
    System.out.println("MyParent3 static block.");
  }
}

package cn.unipus.jvm.classloader;

import java.util.UUID;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/18 11:19
 */
/*
*     当主动使用一个类，对这个类进行初始化时，不需要先初始化这个类实现的接口。
* */
public class MyTest7 {
  public static void main(String[] args) {
    System.out.println(MyChild7.str);
  }
}

interface MyParent7 {
  public static Thread thread = new Thread() {
    {
      System.out.println("the interface MyParent7 initialing.");
    }
  };
}

class MyChild7 implements MyParent7 {
  public static final String str = UUID.randomUUID().toString();
}

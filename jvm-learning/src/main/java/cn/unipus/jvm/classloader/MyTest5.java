package cn.unipus.jvm.classloader;

import java.util.Random;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/17 19:49
 */
/*
*   当一个接口在初始化时，并不要求其父接口都完成了初始化，只有在真正使用到父接口时(例如引用接口中所定义的常量时)，才会初始化。
* */
public class MyTest5 {
}

interface MyParent5 {
  public static int a = 5;
}

interface MyChild5 extends MyParent5 {
  public static final int b = new Random().nextInt(4);
}

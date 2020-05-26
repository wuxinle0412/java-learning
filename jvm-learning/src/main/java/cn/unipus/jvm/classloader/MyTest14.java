package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/19 10:28
 */
/*
*    测试类加载器的加载层次
* */
public class MyTest14 {
  public static void main(String[] args) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    System.out.println(classLoader);

    while (classLoader != null) {
      classLoader = classLoader.getParent();
      System.out.println(classLoader);
    }


  }
}

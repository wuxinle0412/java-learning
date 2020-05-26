package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/18 23:01
 */

/*
*   反射会导致类的初始化
*   loadClass加载一个类，并不是对一个类的主动使用，不会导致类的初始化。
* */
public class MyTest13 {
  public static void main(String[] args) throws ClassNotFoundException {
    ClassLoader loader = ClassLoader.getSystemClassLoader();
    Class<?> clazz = loader.loadClass("cn.unipus.jvm.classloader.CL");
    System.out.println(clazz);
    System.out.println("------------");
    clazz = Class.forName("cn.unipus.jvm.classloader.CL");
    System.out.println(clazz);
  }
}

class CL {
  static {
    System.out.println("Class CL");
  }
}

package cn.unipus.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/19 10:29
 */
/*
*     获取系统类加载器的几种方法:
*     1. 通过当前线程的上下文对象获取  Thread.currentThread().getContextLoader();
*     2. 通过反射获取  clazz.getClassLoader();
*     3. 通过ClassLoader的静态方法获取 ClassLoader.getSystemClassLoader();
*     调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致一个类的初始化。
*
*     数组类型对应的Class对象并不是由类加载器加载的，而是由Java虚拟机在运行时创建的。
*     数组类的类加载来说，数组类型的getClassLoader()是与数组元素的ClassLoader相同。
*     原生类型的数组是没有类加载器的。
* */
public class MyTest15 {
  public static void main(String[] args) throws IOException {
    // 获取的上下文classLoader就是系统类加载器
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    System.out.println(classLoader);
    System.out.println(ClassLoader.getSystemClassLoader());
    String resourceName = "cn/unipus/jvm/classloader/MyTest15.class";
    Enumeration<URL> urls = classLoader.getResources(resourceName);
    while (urls.hasMoreElements()) {
      URL url = urls.nextElement();
      System.out.println(url);
    }
  }
}

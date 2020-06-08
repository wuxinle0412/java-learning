package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/6/8 12:26
 */
public class MyCat {
  public MyCat() {
    System.out.println("MyCat is loaded by: " + getClass().getClassLoader());

  }
}

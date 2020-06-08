package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/6/8 12:38
 */
public class MySample2 {
  public MySample2() {
    System.out.println("MySample2 is loaded by: " + getClass().getClassLoader());

    new MyCat2();
  }
}

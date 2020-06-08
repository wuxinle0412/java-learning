package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/6/8 12:26
 */
public class MySample {
  public MySample() {
    System.out.println("My Sample is loaded by: " + getClass().getClassLoader());

    new MyCat();
  }
}

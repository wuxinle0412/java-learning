package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/6/8 12:47
 */
public class MySample3 {
  public MySample3() {
    System.out.println("MySample3 is loaded by: " + getClass().getClassLoader());

    new MyCat3();

    System.out.println("from MySample3: " + MyCat3.class);
  }
}

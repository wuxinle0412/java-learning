package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/6/8 12:38
 */
public class MyCat2 {
  public MyCat2() {
    System.out.println("MyCat is loaded by: " + getClass().getClassLoader());

    System.out.println("from MyCat2: " + MySample2.class);
  }
}

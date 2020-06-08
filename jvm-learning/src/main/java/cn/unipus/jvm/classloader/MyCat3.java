package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/6/8 12:47
 */
public class MyCat3 {
  public MyCat3() {
    System.out.println("MyCat3 is loaded by: " + getClass().getClassLoader());
  }
}

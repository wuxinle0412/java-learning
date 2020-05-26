package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/18 22:29
 */
public class MyTest9 {
  public static void main(String[] args) {
    System.out.println(FinalTest.x);
  }
}

class FinalTest {
  public static final int x = 3;
  static {
    System.out.println("FinalTest static block.");
  }
}

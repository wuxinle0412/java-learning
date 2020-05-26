package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/18 21:16
 */
public class MyTest8 {
  public static void main(String[] args) throws Exception {
   Class<?> clazz1 = Class.forName("java.lang.String");
   System.out.println(clazz1.getClassLoader());

   Class<?> clazz2 = Class.forName("cn.unipus.jvm.classloader.C");
    System.out.println(clazz2.getClassLoader());
  }
}

class C {

}

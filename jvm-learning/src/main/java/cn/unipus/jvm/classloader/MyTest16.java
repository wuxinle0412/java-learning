package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/20 23:18
 */
public class MyTest16 {
  public static void main(String[] args) {
    String[] strings = new String[2];
    System.out.println(strings.getClass().getClassLoader());
    System.out.println("----------------");
    MyTest16[] myTest16s = new MyTest16[2];
    System.out.println(myTest16s.getClass().getClassLoader());  //数组类型的类加载器与数组元素的类加载器一致。
    System.out.println("-----------------");
    int[] ints = new int[2];
    System.out.println(ints.getClass().getClassLoader());  //原生类型的数组没有类加载器
  }
}

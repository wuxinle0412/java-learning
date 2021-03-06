package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/18 22:35
 */
public class Mytest10 {
  static {
    System.out.println("MyTest10 static block.");
  }
  public static void main(String[] args) {
    System.out.println(Child.b);
  }
}

class Parent {

  static int a = 3;

  static {
    System.out.println("Parent static block.");
  }
}

class Child extends Parent {

  static int b = 4;

  static {
    System.out.println("Child static block.");
  }
}



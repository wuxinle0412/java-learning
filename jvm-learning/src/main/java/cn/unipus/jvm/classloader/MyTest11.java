package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/18 22:48
 */
public class MyTest11 {

  static {
    System.out.println("MyTest10 static block.");
  }
  
  public static void main(String[] args) {
    Parent10 parent10;
    System.out.println("------------");
    parent10 = new Parent10();
    System.out.println("------------");
    System.out.println(Parent10.a);
    System.out.println("------------");
    System.out.println(Child10.b);
  }
}

class Parent10 {

  public static int a = 3;

  static {
    System.out.println("Parent10 static block.");
  }
}

class Child10 extends Parent10 {
  public static int b = 4;

  static {
    System.out.println("Child10 static block.");
  }
}



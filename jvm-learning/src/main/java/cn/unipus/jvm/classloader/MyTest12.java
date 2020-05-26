package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/18 22:53
 */
/*
*     静态变量和静态方法定义在哪个类中就表示对这个类的主动使用，和哪个子类调用这个静态变量和静态方法没有直接关系。
*     类变量属于声明的类。
* */
public class MyTest12 {
  public static void main(String[] args) {
    System.out.println(Child12.a);
    Child12.doSomething();
  }
}

class Parent12 {

  public static int a = 3;

  static {
    System.out.println("Parent12 static block.");
  }

  static void doSomething() {
    System.out.println("do something.");
  }
}

class Child12 extends Parent12 {

  static {
    System.out.println("MyChild12 static block.");
  }
}

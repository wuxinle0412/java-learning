package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/12 23:34
 */

/*
*   原因说明:
*   1) System.out.println(MyChild1.str);
*      My Parent1 static block
       hello world
*      对于静态字段来说，只有直接定义了该字段的类才会被初始化。对于这个例子来说，主动使用了MyTest1.str，并没有主动使用有Child1类
*   2) System.out.println(MyChild.str2);
*      My Parent1 static block
*      My Child1 static block
       hello world
       这个情况主动使用了MyChild1类，初始化MyChild1必须先初始化所有的父类。
       当一个类在初始化时，要求其父类全部都已经被初始化完毕了。

     -XX:TraceClassLoading，用于追踪类的加载信息并打印出来。
     +XX:+<option>，表示开启option选项。
     -XX:-<option>，表示关闭option选项。
     -XX:<option>=<value>，表示将option选项设置为value。

*
* */
public class MyTest1 {
  public static void main(String[] args) {
    System.out.println(MyChild1.str);
  }
}

class MyParent1 {
  public static String str = "hello world";

  static {
    System.out.println("My Parent1 static block");
  }
}

class MyChild1 extends MyParent1 {

  public static String str2 = "welcome";

  static {
    System.out.println("My Child1 static block");
  }
}

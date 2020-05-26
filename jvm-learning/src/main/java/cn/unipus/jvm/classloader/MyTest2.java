package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/17 18:12
 */

/*
*   常量会在编译阶段存入到调用这个类的常量所在的方法所在的类的常量池中，
*   本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化。
*   注意: 这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyTest2就没有任何关系了，甚至我们可以将MyParent2的class文件删除。
*
*   javap -c cn.unipus.jvm.classloader.MyTest2
*
*   助记符:
*   ldc表示将int, float或是String类型的常量值从常量池推送至栈顶。
*   bipush: 表示将单字节(-128~127)的常量值推送至栈顶。
*   sipush: 表示将表示将一个短整型常量值(-32768~32767)推送至栈顶。
*   iconst_1表示将int类型推送至栈顶(iconst_m1~iconst_5，-1至6)。
*
*   com.sun.org.apache.bcel.internal.generic.ICONST: 定义iconst_m1-iconst_5的int类型的常量值。
*   com.sun.org.apache.bcel.internal.generic.BIPUSH:定义bipush类。
*
* */
public class MyTest2 {
  public static void main(String[] args) {
    System.out.println(MyParent2.str);
  }
}

class MyParent2 {
  public static final String str = "hello world";
  public static final short s = 7;
  public static final int i = 128;

  static {
    System.out.println("MyParent2 static block.");
  }
}

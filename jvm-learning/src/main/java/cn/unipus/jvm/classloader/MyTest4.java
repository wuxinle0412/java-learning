package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/17 19:35
 */

/*
*   对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lcn.unipus.jvm.classloader.MyParent4。
*   对于数组来说，JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型。
*
*   anewarray: 表示创建一个引用类型的(如类、数组、接口)数组，并将其引用值压入栈顶。
*   newarray: 表示创建一个指定的原始类型(如int、float、char等)的数组。
* */
public class MyTest4 {
  public static void main(String[] args) {
//    MyParent4 myParent4 = new MyParent4();
//    System.out.println("---------------");
//    MyParent4 myParent5 = new MyParent4();

    MyParent4[] myParent4s = new MyParent4[1];
    System.out.println(myParent4s.getClass());
  }
}

class MyParent4 {
  static {
    System.out.println("MyParent4 static block.");
  }
}

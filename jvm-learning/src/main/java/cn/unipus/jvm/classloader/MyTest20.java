package cn.unipus.jvm.classloader;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/6/8 12:47
 */

/*
*     关于命名空间
*     子加载器所加载的类能够访问到父加载器所加载的类
*     父加载器所加载的类不能够访问到子加载器所加载的类
* */
public class MyTest20 {
  public static void main(String[] args) throws Exception {
    MyTest17 loader = new MyTest17("loader");
    loader.setPath("C:\\Users\\Administrator\\Desktop\\");

    Class<?> clazz = loader.loadClass("cn.unipus.jvm.classloader.MySample3");

    //如果注释改行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
    //因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat Class。
    Object obj = clazz.newInstance();
  }
}

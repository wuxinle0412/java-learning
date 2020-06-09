package cn.unipus.jvm.classloader;

/**
 * @author yd
 * @version 1.0
 * @date 2020/6/8 23:35
 */
/*
*    测试不同类加载器的加载目录，将当前项目classes加入启动类加载器加载目录下，则当前项目的类就可以由启动类加载器加载。
* */
public class MyTest22 {
    public static void main(String[] args) throws Exception {
        MyTest17 loader = new MyTest17("loader");
        loader.setPath("C:\\Users\\Administrator\\Desktop\\");
        Class<?> clazz = loader.loadClass("cn.unipus.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());
    }
}

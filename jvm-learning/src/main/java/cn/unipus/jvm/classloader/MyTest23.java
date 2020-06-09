package cn.unipus.jvm.classloader;

import java.lang.reflect.Method;

/**
 * @author yd
 * @version 1.0
 * @date 2020/6/8 23:46
 */
public class MyTest23 {
    public static void main(String[] args) throws Exception {
        MyTest17 loader1 = new MyTest17("loader1");
        MyTest17 loader2 = new MyTest17("loader2");

        loader1.setPath("C:\\Users\\xinle\\Desktop\\");
        loader2.setPath("C:\\Users\\xinle\\Desktop\\");

        Class<?> clazz1 = loader1.loadClass("cn.unipus.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("cn.unipus.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);  //true  通过双亲委托机制，均由系统类加载器进行加载

        Object object1 = clazz1.newInstance();  //clazz1由loader1加载、clazz2由loader2加载，他们是两个不同的类。
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);

    }
}

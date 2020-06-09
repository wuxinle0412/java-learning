package cn.unipus.jvm.classloader;

/**
 * @author yd
 * @version 1.0
 * @date 2020/6/9 22:33
 */
/*
*
*     java =Djava.ext.dirs=./ 将扩展类加载器加载路径指向当前目录
*     扩展类加载器会从指定路径下加载jar里的类，不会直接寻找.class文件
*     jar cvf test.jar xx.class 将xx.class打成一个jar包
* */
public class MyTest24 {

    static {
        System.out.println("MyTest24 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest24.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
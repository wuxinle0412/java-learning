package cn.unipus.jvm.classloader;

/**
 * @author yd
 * @version 1.0
 * @date 2020/6/8 23:23
 */
/*
*     java -D  -Dxx=xx表示设置系统属性
*
*     在运行期，一个Java类是由该类的完全限定名(binary name，二进制名)和用于加载该类的定义类加载器(defining loader)所共同决定的。
*     如果同样名字(即相同限定名)的类是由两个不同的加载器所加载，那么这些类是不同的。即便.class文件的字节码完全一样，并且从相同的位置
*     加载亦如此。
*
*     在Oracle的Hotspot实现中，系统属性sun.boot.class.path如果修改错了，则vm初始化出错，提示如下错误:
*     Error occurred during initialization of VM
*     java/lang/NoClassDefFoundError: java/lang/Object
*
*     在Hotspot虚拟机中，扩展类加载器，应用类加载器等由Java代码实现的类加载器由启动类加载器进行加载。自定义类加载器由系统类加载器负责加载。
*     启动加载器是内建于JVM当中的，当JVM启动时就会创建一个启动类加载器的实例，然后启动类加载加载扩展类加载器和系统类加载器。
*     当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，这块特殊的机器码叫做启动类加载器(Bootstrap)。
*     启动类加载器并不是Java类，而其他类都是Java类，启动sh类加载器是特定于平台的机器指令，它负责开启整个加载过程。
*     所有类加载器(除了启动类加载器)，都被实现为Java类。不过，总归要有一个组件来加载第一个Java类加载器，从而让整个加载过程能够顺利进行下去
*     加载第一个Java类加载器就是启动类加载器的职责。
*     启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包的类等等。
*
*     java -Djava.system.class.loader=cn.unipus.jvm.classloader.MyTest17 cn.unipus.jvm.classloader.MyTest21 修改系统类加载器
* */
public class MyTest21 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));  //启动类加载器加载路径
        System.out.println(System.getProperty("java.ext.dirs"));  //扩展类加载器加载路径
        System.out.println(System.getProperty("java.class.path"));  //系统类加载器加载路径

        System.out.println(System.getProperty("java.system.class.loader"));
    }
}

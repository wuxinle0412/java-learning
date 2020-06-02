package cn.unipus.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wuxinle
 * @version 1.0
 * @date 2020/5/23 10:50
 */
/*
*     classpath下的类默认会由AppClassLoader加载，当类由自定义的MyTest17加载时，会委托它的双亲AppClassLoader进行加载，AppClassLoader在类路径下找到这个类，就会放回Class对象，加载成功。
*     定义类加载器: 若有一个类加载器能够成功加载Test类，那么这个类被称为定义类加载器，所有能成功返回Class对象引用的类加载器(包括定义类加载器)都被称为初始类加载器。
*     类加载器的命名空间: 每个类加载器都有自己的命令空间，命名空间是由该加载器及所有父加载器所加载的类组成。
*     在同一个命名空间下，不会出现类的完整名字(包括类的包名)相同的两个类，在不同的命名空间下，有可能会出现类的两个完整名字(包括类的包名)相同的两个类。
* */
public class MyTest17 extends ClassLoader {

  private String classLoaderName;

  private final String fileExtension = ".class";

  private String path;

  public void setPath(String path) {
    this.path = path;
  }

  public MyTest17(String classLoaderName) {
    super();  //将系统类加载器当作该类加载器的父加载器
    this.classLoaderName = classLoaderName;
  }

  public MyTest17(ClassLoader parent, String classLoaderName) {
    super(parent);  //显示指定该类加载器的父加载器
    this.classLoaderName = classLoaderName;
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {

    System.out.println("findClass invoked: " + name);
    System.out.println("class loader name: " + this.classLoaderName);
    byte[] data = loadClassData(name);

    // defineClass 将一个字节数组转换成一个Class实例
    return this.defineClass(name, data, 0, data.length);
  }

  private byte[] loadClassData(String name) {
    InputStream is = null;
    byte[] data = null;
    ByteArrayOutputStream bos = null;

    name = name.replace(".", "\\");

    try {
      is = new FileInputStream(new File(this.path + name + fileExtension));
      bos = new ByteArrayOutputStream();

      int ch = 0;

      while ((ch = is.read()) != -1) {
        bos.write(ch);
      }
      data = bos.toByteArray();
    } catch (Exception e) {

    } finally {
      if (is!= null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      if (bos != null) {
        try {
          bos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return data;
  }


  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//    MyTest17 myTest17 = new MyTest17("mytest17");
//    Class<?> clazz = myTest17.loadClass("cn.unipus.jvm.classloader.MyTest1");
//    Object object = clazz.newInstance();
//    System.out.println(object);
//    System.out.println(object.getClass().getClassLoader());

    MyTest17 loader = new MyTest17("loader1");
    loader.setPath("C:\\Users\\xinle\\Desktop\\");  //当前类路径下不存在MyTest1.class, AppClassLoader无法加载，由loader进行加载
    Class<?> clazz = loader.loadClass("cn.unipus.jvm.classloader.MyTest1");
    System.out.println("class: " + clazz.hashCode());
    Object object = clazz.newInstance();
    System.out.println(object);
    System.out.println(object.getClass().getClassLoader());

    MyTest17 loader2 = new MyTest17("loader2");
    loader2.setPath("C:\\Users\\xinle\\Desktop\\");
    Class<?> clazz2 = loader2.loadClass("cn.unipus.jvm.classloader.MyTest1");
    System.out.println("class: " + clazz2.hashCode());
    Object object2 = clazz2.newInstance();
    System.out.println(object2);
    System.out.println(object2.getClass().getClassLoader());

  }

  @Override
  public String toString() {
    return "MyTest17{" +
        "classLoaderName='" + classLoaderName + '\'' +
        ", fileExtension='" + fileExtension + '\'' +
        '}';
  }

}

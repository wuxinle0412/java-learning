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
public class MyTest17 extends ClassLoader {

  private String classLoaderName;

  private final String fileExtension = ".class";

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
    byte[] data = loadClassData(name);

    // defineClass 将一个字节数组转换成一个Class实例
    return this.defineClass(name, data, 0, data.length);
  }

  private byte[] loadClassData(String name) {
    InputStream is = null;
    byte[] data = null;
    ByteArrayOutputStream bos = null;

    try {
      is = new FileInputStream(new File(name + fileExtension));
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
    MyTest17 myTest17 = new MyTest17("mytest17");
    Class<?> clazz = myTest17.loadClass("cn.unipus.jvm.classloader.MyTest1");
    Object object = clazz.newInstance();
    System.out.println(object);
  }

  @Override
  public String toString() {
    return "MyTest17{" +
        "classLoaderName='" + classLoaderName + '\'' +
        ", fileExtension='" + fileExtension + '\'' +
        '}';
  }

}

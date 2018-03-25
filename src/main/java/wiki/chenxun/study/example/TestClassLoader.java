package wiki.chenxun.study.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author chenxun created at 2018/3/22
 */
public class TestClassLoader {


  public static void main(String[] args) throws IOException {
    //test1();
    //test2();
    test3();

    System.in.read();

  }


  public static void test1(){

    ClassLoader myClassLoader = new ClassLoader() {};
    try {
      Class cls = myClassLoader.loadClass(TestClassLoader.class.getName());

      System.out.println(myClassLoader.getParent());
      System.out.println(cls.getClassLoader());

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }


  }

  public static void  test2(){

    ServiceLoader<SPITest> loaders= ServiceLoader.load(SPITest.class);
    loaders.forEach(i->{
          i.test();
    });


  }

  public static void test3()  {
    Class cls=null;
    ClassLoader myClassLoader = new ClassLoader() {

      @Override protected Class<?> findClass(String name) throws ClassNotFoundException {


        try(BufferedReader reader=new BufferedReader(new FileReader("/Users/chenxun/study/study-example/src/tmp/TestLoader.class"))){
          StringBuilder stringBuilder=new StringBuilder();
          while (reader.ready()){
            stringBuilder.append(reader.readLine());
          }
          String clsString=stringBuilder.toString();
          return   defineClass(name,clsString.getBytes(),0,clsString.length());

        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
          return null;
      }
    };

    try {
      Class testLoader = myClassLoader.loadClass("TestLoader");
      System.out.println(testLoader.newInstance().toString());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }



  }



}

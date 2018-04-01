package wiki.chenxun.study.example;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenxun created at 2018/4/1
 */
public class CopyOnWriterTest {



  public static void main(String[] args) {

    CopyOnWriteArrayList<Integer>  list=new CopyOnWriteArrayList();

    list.add(123);
    list.add(234);
    System.out.println(list.get(0));

    list.parallelStream().forEach(i->{
      System.out.println(i);
    });



  }


}

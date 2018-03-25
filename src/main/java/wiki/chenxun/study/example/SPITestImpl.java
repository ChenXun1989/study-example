package wiki.chenxun.study.example;

/**
 * @author chenxun created at 2018/3/24
 */
public class SPITestImpl  implements SPITest{
  @Override public void test() {
    System.out.println("spiTest");
  }
}

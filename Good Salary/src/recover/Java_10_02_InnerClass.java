package recover;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-05-14 15：06 邮箱：wwb199055@126.com */
public class Java_10_02_InnerClass {

  @Test
  public void execute() {
    final int s = 10;

    class InnerClass {


      public void run() {

        new Thread() {
          @Override
          public void run() {
            try {
              Thread.currentThread().sleep(15);
              System.out.println(System.currentTimeMillis());
            } catch (final Exception e) {
              e.printStackTrace();
            }
          }
        }.start();
      }
    }

    new InnerClass().run();
    System.out.println("住方法已经Over啦！");
  }
}

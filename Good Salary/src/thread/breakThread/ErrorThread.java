package thread.breakThread;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-08-20 17：28 邮箱：wwb199055@126.com */
public class ErrorThread {

  public class MyThread extends Thread {
    @Override
    public void run() {
      /*for (int i = 0; i < 50000; i++) {
        if (this.isInterrupted()) {
          System.out.println("线程已经结束，我要退出");
          break;
        }
        System.out.println("i=" + (i + 1));
      }
      System.out.println("我是for下面的语句，我被执行说明线程没有真正结束");*/

      try {
        for (int i = 0; i < 50000; i++) {
          if (this.isInterrupted()) {
            System.out.println("线程已经结束，我要退出");
            //                    return;
            throw new InterruptedException();
          }
          System.out.println("i=" + (i + 1));
        }
        System.out.println("我是for下面的语句，我被执行说明线程没有真正结束");
      } catch (InterruptedException e) {
        System.out.println("进入MyThread.java类中run方法的catch异常了");
        e.printStackTrace();
      }
    }
  }



  /*@Test*/
  public void test() {
    try {
      Thread thread = new MyThread();
      thread.start();
      System.out.println(System.currentTimeMillis() / 1000 + "--------->");
      Thread.sleep(20);
      System.out.println(System.currentTimeMillis() / 1000 + "--------->");
      thread.interrupt();
    } catch (InterruptedException e) {
      System.out.println("main catch");
      e.printStackTrace();
    }
  }
}

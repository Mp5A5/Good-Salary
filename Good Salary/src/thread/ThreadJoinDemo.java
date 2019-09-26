package thread;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-08-20 11：19 邮箱：wwb199055@126.com */
public class ThreadJoinDemo {

  public class MyThread implements Runnable {

    @Override
    public void run() {
      for (int i = 0; i < 20; i++) {
        System.out.println(Thread.currentThread().getName() + "运行，i = " + i);
      }
    }
  }

  @Test
  public void test() {
    MyThread thread = new MyThread();
    Thread t = new Thread(thread, "线程");
    t.start();

    for (int i = 0; i < 20; i++) {
      if (i > 5) {
        try {
          t.join(); // 线程强制运行
        } catch (InterruptedException e) {
        }
      }
      System.out.println("Main线程运行 --> " + i);
    }
  }
}

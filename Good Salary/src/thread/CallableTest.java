package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/** 作者：王文彬 on 2019-08-20 10：11 邮箱：wwb199055@126.com */
public class CallableTest {

  private static class MyThread implements Callable {

    private String name;

    public MyThread(String name) {
      this.name = name;
    }

    @Override
    public Object call() throws Exception {
      for (int i = 0; i < 10; i++) {
        System.out.println(name + "运行，i = " + i);
      }
      return null;
    }
  }

  public static void main(String[] args) {
    Callable c1 = new MyThread("线程A");
    Callable c2 = new MyThread("线程B");
    FutureTask f1 = new FutureTask(c1);
    Thread t1 = new Thread(f1);
    t1.start();
    FutureTask f2 = new FutureTask(c2);
    Thread t2 = new Thread(f2);
    t2.start();
  }
}

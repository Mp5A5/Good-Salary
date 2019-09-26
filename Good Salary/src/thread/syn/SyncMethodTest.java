package thread.syn;

import java.util.concurrent.TimeUnit;

/** 作者：王文彬 on 2019/8/28 18：27 邮箱：wwb199055@126.com */
public class SyncMethodTest {

  public static void main(String[] args) {
    SyncMethod method = new SyncMethod();

    for (int i = 0; i < 10; i++) {
      new Thread(method::syncMethod1).start();
      new Thread(method::syncMethod2).start();
    }
  }
}

class SyncMethod {

  public synchronized void syncMethod1() {
    System.out.println(Thread.currentThread().getName() + "-->" + "syncMethod1 获得🔐");
    try {
      TimeUnit.SECONDS.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("1分钟后，syncMethod1 释放🔐");
  }

  public synchronized void syncMethod2() {
    System.out.println(Thread.currentThread().getName() + "-->" + "syncMethod2 获得🔐");
    try {
      TimeUnit.SECONDS.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("1分钟后，syncMethod2 释放🔐");
  }
}

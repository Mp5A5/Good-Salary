package lock.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 作者：王文彬 on 2019-08-25 15：36 邮箱：wwb199055@126.com */
public class Ticket implements Runnable {
  private volatile int ticket = 100;

  // ReentrantLock 可重入锁  Lock接口的实现类之一

  private Lock lock = new ReentrantLock();

  @Override
  public void run() {

    while (true) {
      try {
        lock.lock();
        // 放大多线程问题
        Thread.sleep(200);
        if (ticket > 0) {
          System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --ticket);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        // 保证锁的释放
        lock.unlock();
      }
    }
  }
}

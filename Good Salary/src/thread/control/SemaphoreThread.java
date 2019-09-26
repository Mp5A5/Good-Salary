package thread.control;

import java.util.concurrent.Semaphore;

/** 作者：王文彬 on 2019/8/26 22：18 邮箱：wwb199055@126.com */
public class SemaphoreThread extends Thread {

  private Semaphore semaphore = new Semaphore(6);

  @Override
  public void run() {
    try {
      semaphore.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + "--in");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + "--out");
    semaphore.release();
  }
}

class STest {
  public static void main(String[] args) {

    for (int i = 0; i < 20; i++) {
      Thread thread = new SemaphoreThread();
      thread.setName("threat index:" + i);
      thread.start();
    }
  }
}


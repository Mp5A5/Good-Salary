package thread.syn;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/** 作者：王文彬 on 2019/8/28 11：53 邮箱：wwb199055@126.com */
public class CountDownLatchTest {
  public static void main(String[] args) {

    CountDownLatch countDownLatch = new CountDownLatch(5);

    for (int i = 0; i < 5; i++) {
      new Thread(
              () -> {
                System.out.println(Thread.currentThread().getName() + " " + new Date() + " run");
                try {
                  Thread.sleep(5000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
                countDownLatch.countDown();
              })
          .start();
    }
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("all thread over");
  }

}

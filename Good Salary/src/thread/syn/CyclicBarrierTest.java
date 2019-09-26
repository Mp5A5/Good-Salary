package thread.syn;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** 作者：王文彬 on 2019/8/28 12：05 邮箱：wwb199055@126.com */
public class CyclicBarrierTest {

  public static void main(String[] args) {
    Random random = new Random();
    CyclicBarrier barrier = new CyclicBarrier(5);
    for (int i = 0; i < 5; i++) {
      new Thread(
              () -> {
                int secs = random.nextInt(5);
                System.out.println(
                    Thread.currentThread().getName()
                        + " "
                        + new Date()
                        + " run, sleep "
                        + secs
                        + " secs");
                try {
                  Thread.sleep(secs * 1000);
                  barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                  e.printStackTrace();
                }
                System.out.println(
                    Thread.currentThread().getName() + " " + new Date() + " runs over");
              })
          .start();
    }
  }
}

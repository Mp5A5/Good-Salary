package lock.consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 作者：王文彬 on 2019-08-25 15：56 邮箱：wwb199055@126.com */
public class TestProductConsumerLock {

  public static void main(String[] args) {
    ClerkLock clerk = new ClerkLock();
    ProductLock product = new ProductLock(clerk);
    ConsumerLock consumer = new ConsumerLock(clerk);
    new Thread(product, "生产者A").start();
    new Thread(consumer, "消费者B").start();
    new Thread(product, "生产者C").start();
    new Thread(consumer, "消费者D").start();
  }
}

// 店员
class ClerkLock {

  private int product = 0;
  private Lock lock = new ReentrantLock();
  // 获取condition
  private Condition condition = lock.newCondition();

  public void product() {
    lock.lock();
    try {
      while (product >= 1) {
        System.out.println("产品已满");
        try {
          // 使用condition的await
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(Thread.currentThread().getName() + " :当前有 " + (++product));
      // 使用condition的signalAll
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }

  // 卖货 方法使用synchronized 修饰
  public void sale() {
    lock.lock();
    try {
      while (product <= 0) {
        System.out.println(Thread.currentThread().getName() + "缺货！");
        try {
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println(Thread.currentThread().getName() + " :余剩有 " + (--product));
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }
}

class ProductLock implements Runnable {

  private ClerkLock clerk;

  public ProductLock(ClerkLock clerk) {
    this.clerk = clerk;
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      try {
        // 睡眠0.2s
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      clerk.product();
    }
  }
}

class ConsumerLock implements Runnable {
  private ClerkLock clerk;

  public ConsumerLock(ClerkLock clerk) {
    this.clerk = clerk;
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      clerk.sale();
    }
  }
}

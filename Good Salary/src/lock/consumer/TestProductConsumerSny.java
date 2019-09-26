package lock.consumer;

/** 作者：王文彬 on 2019-08-25 15：56 邮箱：wwb199055@126.com */
public class TestProductConsumerSny {

  public static void main(String[] args) {
    ClerkLock clerk = new ClerkLock();
    Product product = new Product(clerk);
    Consumer consumer = new Consumer(clerk);
    new Thread(product, "生产者A").start();
    new Thread(consumer, "消费者B").start();
    new Thread(product, "生产者C").start();
    new Thread(consumer, "消费者D").start();
  }
}

// 店员
class Clerk {

  private int product = 0;
  // 进货 方法使用synchronized 修饰
  public synchronized void product() {
    //    if (product >= 1)

    while (product >= 1) {
      System.out.println("产品已满");
      try {
        // 唤醒后会继续进行while循环判断
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(Thread.currentThread().getName() + " :当前有 " + (++product));
    this.notifyAll();
    /*else {
        System.out.println(Thread.currentThread().getName()+" :当前有 "+(++product));
      this.notifyAll();
    }*/
  }

  // 卖货 方法使用synchronized 修饰
  public synchronized void sale() {
    //    if (product <= 0)

    while (product <= 0) {
      System.out.println(Thread.currentThread().getName() + "缺货！");
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(Thread.currentThread().getName() + " :余剩有 " + (--product));
    this.notifyAll();
    /*else {
        System.out.println(Thread.currentThread().getName()+" :余剩有 "+(--product));
      this.notifyAll();
    }*/
  }
}

class Product implements Runnable {

  private ClerkLock clerk;

  public Product(ClerkLock clerk) {
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

class Consumer implements Runnable {
  private ClerkLock clerk;

  public Consumer(ClerkLock clerk) {
    this.clerk = clerk;
  }

  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      clerk.sale();
    }
  }
}

package lock.dead;

/** 作者：王文彬 on 2019/8/26 15：37 邮箱：wwb199055@126.com */
public class DeadLock implements Runnable {

  private static final Object OBJ1 = new Object();
  private static final Object OBJ2 = new Object();
  private boolean flag;

  public DeadLock(boolean flag) {
    this.flag = flag;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "运行");

    if (flag) {
      synchronized (OBJ1) {
        System.out.println(Thread.currentThread().getName() + "已经锁住obj1");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (OBJ2) {
          // 执行不到这里
          System.out.println("1秒钟后，" + Thread.currentThread().getName() + "锁住obj2");
        }
      }
    } else {
      synchronized (OBJ2) {
        System.out.println(Thread.currentThread().getName() + "已经锁住obj2");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (OBJ1) {
          // 执行不到这里
          System.out.println("1秒钟后，" + Thread.currentThread().getName() + "锁住obj1");
        }
      }
    }
  }
}

class Test {
  public static void main(String[] args) {
    Thread t1 = new Thread(new DeadLock(true), "线程1");
    Thread t2 = new Thread(new DeadLock(true), "线程2");

    t1.start();
    t2.start();
  }
}

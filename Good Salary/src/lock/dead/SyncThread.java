package lock.dead;

/** 作者：王文彬 on 2019/8/26 15：49 邮箱：wwb199055@126.com */
public class SyncThread implements Runnable {

  private Object obj1;
  private Object obj2;

  public SyncThread(Object o1, Object o2) {
    this.obj1 = o1;
    this.obj2 = o2;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    synchronized (obj1) {
      System.out.println(name + " acquired lock on " + obj1);
      work();
      synchronized (obj2) {
        System.out.println("After, " + name + " acquired lock on " + obj2);
        work();
      }
      System.out.println(name + " released lock on " + obj2);
    }
    System.out.println(name + " released lock on " + obj1);
    System.out.println(name + " finished execution.");
  }

  private void work() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class SynTest {
  public static void main(String[] args) throws InterruptedException {
    Object obj1 = new Object();
    Object obj2 = new Object();
    Object obj3 = new Object();

    Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
    Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
    Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

    t1.start();
    Thread.sleep(1000);
    t2.start();
    Thread.sleep(1000);
    t3.start();
  }
}

package lock.dead;

/** 作者：王文彬 on 2019/8/26 16：01 邮箱：wwb199055@126.com */
public class SynThread1 implements Runnable {

  private Object obj1;
  private Object obj2;

  public SynThread1(Object obj1, Object obj2) {
    this.obj1 = obj1;
    this.obj2 = obj2;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    synchronized (obj1) {
      System.out.println(name + " acquired lock on " + obj1);
      work();
    }
    System.out.println(name + " released lock on " + obj1);
    synchronized (obj2) {
      System.out.println("After, " + name + " acquired lock on " + obj2);
      work();
    }
    System.out.println(name + " released lock on " + obj2);
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

class STest {
  public static void main(String[] args) throws InterruptedException {
    Object obj1 = new Object();
    Object obj2 = new Object();
    Object obj3 = new Object();

    Thread t1 = new Thread(new SynThread1(obj1, obj2), "t1");
    Thread t2 = new Thread(new SynThread1(obj2, obj3), "t2");
    Thread t3 = new Thread(new SynThread1(obj3, obj1), "t3");
    t1.start();
    Thread.sleep(1000);
    t2.start();
    Thread.sleep(1000);
    t3.start();
  }
}

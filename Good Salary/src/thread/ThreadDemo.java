package thread;

/** 作者：王文彬 on 2019-08-20 11：05 邮箱：wwb199055@126.com */
public class ThreadDemo {

  private static class MyThread extends Thread {

    private int ticket = 5;

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        if (ticket > 0)
          System.out.println(Thread.currentThread().getName() + "卖票：ticket" + ticket--);
      }
    }
  }

  public static void main(String[] args) {
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    MyThread t3 = new MyThread();
    t1.start();
    t2.start();
    t3.start();
  }
}

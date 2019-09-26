package thread;

/** 作者：王文彬 on 2019-08-20 11：08 邮箱：wwb199055@126.com */
public class RunnableDemo {

  private static class MyThread implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        if (ticket > 0) {
          System.out.println(Thread.currentThread().getName() + "买票：ticket=" + ticket--);
        }
      }
    }
  }

  public static void main(String[] args) {

    MyThread thread = new MyThread();

    Thread t1 = new Thread(thread, "t1");
    t1.start();
    Thread t2 = new Thread(thread, "t2");
    t2.start();
    Thread t3 = new Thread(thread, "t3");
    t3.start();
  }
}

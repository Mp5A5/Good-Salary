package thread.yield;

/** 作者：王文彬 on 2019-08-20 18：53 邮箱：wwb199055@126.com */
public class ThreadYieldDemo {

  static class MyThread implements Runnable {

    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        try {
          Thread.sleep(500);
        } catch (Exception e) {
        }
        System.out.println(Thread.currentThread().getName() + "运行，i = " + i); // 取得当前线程的名字
        if (i == 2) {
          System.out.print("线程礼让：");
          Thread.yield(); // 线程礼让
        }
      }
    }
  }

  public static void main(String[] args) {
    MyThread my = new MyThread(); // 实例化MyThread对象
    Thread t1 = new Thread(my, "线程A");
    Thread t2 = new Thread(my, "线程B");
    t1.start();
    t2.start();
  }
}

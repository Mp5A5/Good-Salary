package thread;

/** 作者：王文彬 on 2019-08-20 11：28 邮箱：wwb199055@126.com */
public class ThreadSleepDemo {

  static class MyThread implements Runnable { // 实现Runnable接口
    public void run() { // 覆写run()方法
      for (int i = 0; i < 20; i++) {
        try {
          Thread.sleep(500); // 线程休眠
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + "运行，i = " + i); // 取得当前线程的名字
      }
    }
  };

  public static void main(String args[]) {
    MyThread mt = new MyThread(); // 实例化Runnable子类对象
    Thread t = new Thread(mt, "线程"); // 实例化Thread对象
    t.start(); // 启动线程
  }
}

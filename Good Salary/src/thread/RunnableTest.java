package thread;

/** 作者：王文彬 on 2019-08-20 09：59 邮箱：wwb199055@126.com */
public class RunnableTest {

 private static class MyThread implements Runnable {

    private String name;

    public MyThread(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        System.out.println(name + "运行，i = " + i);
      }
    }
  }

  public static void main(String[] args) {
    MyThread thread1 = new MyThread("线程A");
    MyThread thread2 = new MyThread("线程B");

    Thread t1 = new Thread(thread1);
    Thread t2 = new Thread(thread2);
    t1.start();
    t2.start();
  }
}

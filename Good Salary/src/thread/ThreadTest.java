package thread;

/** 作者：王文彬 on 2019-08-20 10：04 邮箱：wwb199055@126.com */
public class ThreadTest {

  private static class MyThread extends Thread {
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
      MyThread t1 = new MyThread("线程A");
      MyThread t2 = new MyThread("线程B");
      t1.start();
      t2.start();
  }
}

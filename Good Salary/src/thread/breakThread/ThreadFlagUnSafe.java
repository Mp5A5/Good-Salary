package thread.breakThread;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-08-20 16：18 邮箱：wwb199055@126.com */
public class ThreadFlagUnSafe {

  public User user = new User();

  // 改变user变量的线程
  public class ChangeObjectThread extends Thread {

    // 用于停止线程
    private boolean stopMe = true;

    public void stopMe() {
      stopMe = false;
    }

    @Override
    public void run() {

      while (stopMe) {
        synchronized (ThreadFlagUnSafe.class) {
          int v = (int) (System.currentTimeMillis() / 1000);
          user.setId(v);
          // to do sth
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          user.setName(String.valueOf(v));
        }
        // 让出CPU，给其他线程执行
        Thread.yield();
      }

    }
  }

  public class ReadObjectThread extends Thread {
    @Override
    public void run() {
      while (true) {
        synchronized (ThreadFlagUnSafe.class) {
          System.out.println(user.toString());
          // 让出CPU，给其他线程执行
          Thread.yield();
        }
      }
    }
  }

  @Test
  public void test() throws InterruptedException {
    new ReadObjectThread().start();

    while (true) {
      ChangeObjectThread thread = new ChangeObjectThread();
      thread.start();
      Thread.sleep(150);
      // 使用stop()方法，强制停止线程
      thread.stopMe();
    }
  }
}

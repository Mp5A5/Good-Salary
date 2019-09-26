package thread.breakThread;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-08-20 16：18 邮箱：wwb199055@126.com */
public class ThreadStopUnSafe {

  public User user = new User();

  // 改变user变量的线程
  public class ChangeObjectThread extends Thread {

    @Override
    public void run() {

      while (true) {
        synchronized (ThreadStopUnSafe.class) {
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

  // 读取user变量的线程
  public class ReadObjectThread extends Thread {
    @Override
    public void run() {
      while (true) {
        synchronized (ThreadStopUnSafe.class) {
          if (user.getId() != Integer.parseInt(user.getName())) {
            System.out.println(user.toString());
          }
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
      Thread thread = new ChangeObjectThread();
      thread.start();
      Thread.sleep(150);
      // 使用stop()方法，强制停止线程
      thread.stop();
    }
  }
}

package thread.breakThread;

import java.util.concurrent.TimeUnit;

/** 作者：王文彬 on 2019-08-20 17：02 邮箱：wwb199055@126.com */
public class Interrupted {

  static class SleepRunner implements Runnable {
    @Override
    public void run() {
      while (true) {
        try {
          TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
          // e.printStackTrace();
        }
      }
    }
  }

  static class BusyRunner implements Runnable {
    @Override
    public void run() {
      while (true) {}
    }
  }

  public static void main(String[] args) throws InterruptedException {
    // sleepThread不停的尝试睡眠
    Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
    sleepThread.setDaemon(true);
    // busyThread不停的运行
    Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
    busyThread.setDaemon(true);
    sleepThread.start();
    busyThread.start();
    // 休眠5秒，让sleepThread和busyThread充分运行
    TimeUnit.SECONDS.sleep(5);
    sleepThread.interrupt();
    busyThread.interrupt();
    System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
    System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
    // 防止sleepThread和busyThread立刻退出
    TimeUnit.SECONDS.sleep(2);
  }
}

package thread.breakThread;

/** 作者：王文彬 on 2019-08-20 17：22 邮箱：wwb199055@126.com */
public class ThreadStopSafeInterrupted {

  public static void main(String[] args) {
    Thread thread =
        new Thread(
            () -> {
              int i = 0;
              while (true) {
                System.out.println(i++);
                // 使用中断机制，来终止线程
                if (Thread.currentThread().isInterrupted()) {
                  System.out.println("Interrupted ...");
                  break;
                }
                try {
                  Thread.sleep(3000);
                } catch (InterruptedException e) {
                  System.out.println("Interrupted When Sleep ...");
                  // Thread.sleep()方法由于中断抛出异常。
                  // Java虚拟机会先将该线程的中断标识位清除，然后抛出InterruptedException，
                  // 因为在发生InterruptedException异常的时候，会清除中断标记
                  // 如果不加处理，那么下一次循环开始的时候，就无法捕获这个异常。
                  // 故在异常处理中，再次设置中断标记位
                  Thread.currentThread().interrupt();
                }
              }
            });
    thread.start();
    try {
      System.out.println(System.currentTimeMillis() / 1000);
      Thread.sleep(2000);
      System.out.println(System.currentTimeMillis() / 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.interrupt();
  }
}

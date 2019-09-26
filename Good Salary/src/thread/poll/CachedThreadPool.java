package thread.poll;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** 作者：王文彬 on 2019/8/28 18：59 邮箱：wwb199055@126.com */
public class CachedThreadPool {
  public static void main(String[] args) {
    Deque<String> stack = new ArrayDeque<>();
    stack.add("帅");
    stack.push("德");
    stack.push("文");
    System.out.println(stack.pop());
    /*ExecutorService executorService = Executors.newSingleThreadExecutor();
    for (int i = 0; i < 100; i++) {
      executorService.execute(() -> System.out.println("a"));
      executorService.execute(() -> System.out.println("b"));
      executorService.execute(() -> System.out.println("c"));
    }

    executorService.shutdown();*/
    /*// 每隔一段时间就触发异常
    executorService.scheduleAtFixedRate(
        () -> System.out.println("==================="), 1000, 5000, TimeUnit.MILLISECONDS);

    // 每隔一段时间打印系统时间，证明两者是互不影响的
    executorService.scheduleAtFixedRate(
        () -> System.out.println(System.currentTimeMillis() / 1000),
        1000,
        2000,
        TimeUnit.MILLISECONDS);*/
  }
}

class MyRunnable implements Runnable {

  private int a = 5;

  @Override
  public void run() {
    synchronized (this) {
      for (int i = 0; i < 10; i++) {
        if (this.a > 0) {
          System.out.println(Thread.currentThread().getName() + " a的值:" + this.a--);
        }
      }
    }
  }
}

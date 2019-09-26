package thread.breakThread;

/** 作者：王文彬 on 2019-08-20 17：45 邮箱：wwb199055@126.com */
public class Test {

  public static void main(String[] args) throws InterruptedException {
    Thread thread =
        new Thread(
            () -> {
              for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(i);
              }
            });
    thread.start();
    System.out.println("线程开始运行啦");
    System.out.println(System.currentTimeMillis() / 1000);
    Thread.sleep(5);
    System.out.println(Thread.currentThread().getName());
    System.out.println("线程结束运行啦");
  }
}

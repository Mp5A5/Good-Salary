package thread;

/** 作者：王文彬 on 2019/9/4 10：08 邮箱：wwb199055@126.com */
public class TestVolatile {
  public static void main(String[] args) {

    ThreadVDemo runnable = new ThreadVDemo();

    new Thread(runnable, "ThreadDemo").start();

    while (true) {
      // 加上下面三句代码的任意一句，程序都会正常结束：
      // System.out.println("!!");                              //...语句1
      // synchronized (TestVolite.class) {}                     //...语句2
      // TestVolatile.test2();                                    //...语句3

      // 若只加上下面一句代码，程序都会死循环：
      TestVolatile.test1(); // ...语句4

      if (runnable.flag) {
        System.out.println("线程 " + Thread.currentThread().getName() + " 即将跳出while循环体... ");
        break;
      }
    }
  }

  public static void test1() {}

  public static synchronized void test2() {}
}

class ThreadVDemo implements Runnable {

  public boolean flag = false;

  @Override
  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
    }
    flag = true;
    System.out.println(
        "线程 " + Thread.currentThread().getName() + " 执行完毕： " + "置  flag= " + flag + " ...");
  }
}

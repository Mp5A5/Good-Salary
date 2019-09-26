package thread;

import java.util.ArrayList;
import java.util.List;

/** 作者：王文彬 on 2019/9/4 09：13 邮箱：wwb199055@126.com */
public class VolatileDemo {
  public static void main(String[] args) {

    MyList service = new MyList();

    ThreadA a = new ThreadA(service);
    a.setName("A");
    a.start();

    ThreadB b = new ThreadB(service);
    b.setName("B");
    b.start();
  }
}

class MyList {
  // 临界资源
  private volatile List<String> list = new ArrayList<>();

  // 对临界资源的访问
  public void add() {
    list.add("mp5a5");
  }

  public int size() {
    return list.size();
  }
}

// 线程B
class ThreadB extends Thread {

  private MyList list;

  public ThreadB(MyList list) {
    super();
    this.list = list;
  }

  @Override
  public void run() { // 任务 B
    try {
      while (true) {
        if (list.size() == 2) {
          System.out.println("list中的元素个数为2了，线程b要退出了！");
          throw new InterruptedException();
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

// 线程A
class ThreadA extends Thread {

  private MyList list;

  public ThreadA(MyList list) {
    super();
    this.list = list;
  }

  @Override
  public void run() { // 任务 A
    try {
      for (int i = 0; i < 3; i++) {
        list.add();
        System.out.println("添加了" + (i + 1) + "个元素");
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

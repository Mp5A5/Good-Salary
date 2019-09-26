package thread;

/** 作者：王文彬 on 2019/8/26 16：37 邮箱：wwb199055@126.com */
public class RTDifferThread {
  public static void main(String[] args) {
    TaskThread runner = new TaskThread();
    runner.run();
    Thread thTask1 = new Thread(runner);
    thTask1.run();
    Thread thTask2 = new Thread(runner);
    thTask2.start();
    Thread thTaskBG1 = new TaskBGThread();
    thTaskBG1.start();
    Thread thTaskBG2 = new TaskBGThread();
    thTaskBG2.start();
  }
}

class TaskBGThread extends Thread {
  private int i = 1;

  @Override
  public void run() {
    System.out.println("TaskBG：" + i);
    i++;
  }
}

class TaskThread implements Runnable {
  private int i = 1;

  @Override
  public void run() {
    System.out.println("Task：" + i);
    i++;
  }
}

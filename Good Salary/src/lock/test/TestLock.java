package lock.test;

/** 作者：王文彬 on 2019-08-25 15：37 邮箱：wwb199055@126.com */
public class TestLock {

  public static void main(String[] args) {
    Ticket ticket = new Ticket();
    new Thread(ticket, "1号窗口").start();
    new Thread(ticket, "2号窗口").start();
    new Thread(ticket, "3号窗口").start();
  }
}

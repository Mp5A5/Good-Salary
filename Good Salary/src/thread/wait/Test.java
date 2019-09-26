package thread.wait;

/** 作者：王文彬 on 2019-08-20 11：51 邮箱：wwb199055@126.com */
public class Test {

  public static void main(String[] args) {
    Service service = new Service();

    Thread t1 = new Thread(new SleepThread(service));
    Thread t2 = new Thread(new WaitThread(service));

    t2.start();
    t1.start();
  }
}

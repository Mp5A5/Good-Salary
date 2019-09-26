package thread.wait;

/** 作者：王文彬 on 2019-08-20 11：51 邮箱：wwb199055@126.com */
public class WaitThread implements Runnable {

  private Service service;

  public WaitThread(Service service) {
    this.service = service;
  }

  @Override
  public void run() {
    service.mWait();
  }
}

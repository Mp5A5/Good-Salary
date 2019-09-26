package thread.sleep;

/** 作者：王文彬 on 2019-08-20 11：50 邮箱：wwb199055@126.com */
public class SleepThread implements Runnable {

  private Service service;

  public SleepThread(Service service) {
    this.service = service;
  }

  @Override
  public void run() {
    service.mSleep();
  }
}

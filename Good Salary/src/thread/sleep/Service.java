package thread.sleep;

/** 作者：王文彬 on 2019-08-20 11：48 邮箱：wwb199055@126.com */
public class Service {
  public void mSleep() {
    synchronized (this) {
      try {
        System.out.println(" Sleep 。当前时间：" + System.currentTimeMillis());
        Thread.sleep(3 * 1000);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }

  public void mWait() {
    synchronized (this) {
      System.out.println(" Wait 。结束时间：" + System.currentTimeMillis());
    }
  }
}

package thread.syn;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/** 作者：王文彬 on 2019/8/28 12：13 邮箱：wwb199055@126.com */
public class MySynchronizerTest {

  public static void main(String[] args) {
    MySynchronizer synchronizer = new MySynchronizer();

    new Thread(
            () -> {
              synchronizer.lock();
              try {
                System.out.println(Thread.currentThread().getName() + " run");
                System.out.println(Thread.currentThread().getName() + " will sleep 5 secs");
                try {
                  Thread.sleep(5000L);
                  System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                  System.err.println(Thread.currentThread().getName() + " interrupted");
                  Thread.currentThread().interrupt();
                }
              } finally {
                synchronizer.unlock();
              }
            })
        .start();

    new Thread(
            () -> {
              synchronizer.lock();
              try {
                System.out.println(Thread.currentThread().getName() + " run");
                System.out.println(Thread.currentThread().getName() + " will sleep 5 secs");
                try {
                  Thread.sleep(5000L);
                  System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                  System.err.println(Thread.currentThread().getName() + " interrupted");
                  Thread.currentThread().interrupt();
                }
              } finally {
                synchronizer.unlock();
              }
            })
        .start();
  }
}

class MySynchronizer extends AbstractQueuedSynchronizer {

  @Override
  protected boolean tryAcquire(int arg) {
    if (compareAndSetState(0, 1)) {
      setExclusiveOwnerThread(Thread.currentThread());
      return true;
    }
    return false;
  }

  @Override
  protected boolean tryRelease(int arg) {
    setState(0);
    setExclusiveOwnerThread(null);
    return true;
  }

  public void lock() {
    acquire(1);
  }

  public void unlock() {
    release(1);
  }

  public static synchronized void test() {}
}

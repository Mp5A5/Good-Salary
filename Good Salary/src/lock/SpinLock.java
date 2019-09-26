package lock;

import java.util.concurrent.atomic.AtomicReference;

/** 作者：王文彬 on 2019-08-20 23：35 邮箱：wwb199055@126.com */
public class SpinLock {

  private AtomicReference<Thread> sign = new AtomicReference<>();

  public void lock() {
    Thread current = Thread.currentThread();
    while (!sign.compareAndSet(null, current)) ;
  }

  public void unLock() {
    Thread current = Thread.currentThread();
    sign.compareAndSet(current, null);
  }
}

package singleton.lazy;

import java.util.concurrent.atomic.AtomicReference;

/** 作者：王文彬 on 2019-08-21 22：15 邮箱：wwb199055@126.com */
public class SingletonCAS {

  private static final AtomicReference<SingletonCAS> INSTANCE = new AtomicReference<>();

  private SingletonCAS() {}

  public static SingletonCAS getInstance() {

    for (; ; ) {
      SingletonCAS singletonCAS = INSTANCE.get();
      if (singletonCAS != null) {
        return singletonCAS;
      }

      singletonCAS = new SingletonCAS();
      if (INSTANCE.compareAndSet(null, singletonCAS)) {
        return singletonCAS;
      }
    }
  }
}

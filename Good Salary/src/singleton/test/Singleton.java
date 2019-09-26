package singleton.test;

import java.util.concurrent.atomic.AtomicReference;

/** 作者：王文彬 on 2019-08-25 10：17 邮箱：wwb199055@126.com */
public class Singleton {

  private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();

  private Singleton() {}

  public static Singleton getInstance() {
    for (; ; ) {
      Singleton singleton = INSTANCE.get();
      if (singleton != null) {
        return singleton;
      }

      singleton = new Singleton();

      if (INSTANCE.compareAndSet(null, singleton)) {
        return singleton;
      }
    }
  }
}

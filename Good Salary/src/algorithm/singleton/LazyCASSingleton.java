package algorithm.singleton;

import java.util.concurrent.atomic.AtomicReference;

/** 作者：王文彬 on 2019/9/3 10：20 邮箱：wwb199055@126.com */
public class LazyCASSingleton {

  private static final AtomicReference<LazyCASSingleton> INSTANCE = new AtomicReference<>();

  private LazyCASSingleton() {}

  public static LazyCASSingleton getInstance() {
    for (; ; ) {
      LazyCASSingleton lazyCASSingleton = INSTANCE.get();
      if (lazyCASSingleton != null) return lazyCASSingleton;
      lazyCASSingleton = new LazyCASSingleton();
      if (INSTANCE.compareAndSet(null, lazyCASSingleton)) {
        return lazyCASSingleton;
      }
    }
  }
}

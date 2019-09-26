package algorithm.singleton;

/** 作者：王文彬 on 2019/9/3 10：11 邮箱：wwb199055@126.com */
public class LazyDCLSingleton {
  private static volatile LazyDCLSingleton instance = null;

  private LazyDCLSingleton() {}

  public static LazyDCLSingleton getInstance() {
    if (instance == null) {
      synchronized (LazyDCLSingleton.class) {
        if (instance == null) {
          instance = new LazyDCLSingleton();
        }
      }
    }
    return instance;
  }
}

package singleton.lazy;

import singleton.hungry.Singleton;

/** 作者：王文彬 on 2019-08-21 22：01 邮箱：wwb199055@126.com */
public class SingletonSyn {

  private static SingletonSyn instance = null;

  private SingletonSyn() {}

  public static synchronized SingletonSyn getInstance() {
    if (instance == null) {
      instance = new SingletonSyn();
    }
    return instance;
  }
}

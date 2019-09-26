package singleton.lazy;

/** 作者：王文彬 on 2019-08-21 22：13 邮箱：wwb199055@126.com */
public class SingletonClazz {

  private static class SingletonHolder {
    private static final SingletonClazz INSTANCE = new SingletonClazz();
  }

  private SingletonClazz() {}

  public static SingletonClazz getInstance() {
    return SingletonHolder.INSTANCE;
  }
}

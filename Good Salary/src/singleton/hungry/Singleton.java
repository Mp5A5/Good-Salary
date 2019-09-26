package singleton.hungry;

/** 作者：王文彬 on 2019-08-21 21：47 邮箱：wwb199055@126.com */
public class Singleton {
  // 1. 加载该类时，单例就会自动被创建
  private static Singleton singleton = new Singleton();

  // 2. 构造函数 设置为 私有权限
  // 原因：禁止他人创建实例
  private Singleton() {}

  // 3. 通过调用静态方法获得创建的单例
  public static Singleton getInstance() {
    return singleton;
  }
}

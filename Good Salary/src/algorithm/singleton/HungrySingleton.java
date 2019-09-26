package algorithm.singleton;

/** 作者：王文彬 on 2019/9/3 10：09 邮箱：wwb199055@126.com */
public class HungrySingleton {

  private static HungrySingleton instance = new HungrySingleton();

  private HungrySingleton() {}

  public static HungrySingleton getInstance() {
    return instance;
  }
}

package singleton.lazy;

/** 作者：王文彬 on 2019-08-21 21：57 邮箱：wwb199055@126.com */
public class SingletonBase {
  // 1. 类加载时，先不自动创建单；即，将单例的引用先赋值为 Null
  private static SingletonBase instance = null;

  // 2. 构造函数 设置为 私有权限
  // 原因：禁止他人创建实例
  private SingletonBase() {}

  // 3. 需要时才手动调用 newInstance（） 创建 单例
  public static SingletonBase getInstance() {
    // 先判断单例是否为空，以避免重复创建
    if (instance == null) {
      instance = new SingletonBase();
    }
    return instance;
  }
}

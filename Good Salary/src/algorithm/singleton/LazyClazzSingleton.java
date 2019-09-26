package algorithm.singleton;

/** 作者：王文彬 on 2019/9/3 10：17 邮箱：wwb199055@126.com */
public class LazyClazzSingleton {

  private static class LazyClazzSingletonHolder {
    private static final LazyClazzSingleton INSTANCE = new LazyClazzSingleton();
  }

  private LazyClazzSingleton() {}

  public static LazyClazzSingleton getInstance() {
    return LazyClazzSingletonHolder.INSTANCE;
  }
}

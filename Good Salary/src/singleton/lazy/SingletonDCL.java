package singleton.lazy;

/** 作者：王文彬 on 2019-08-21 22：06 邮箱：wwb199055@126.com */
public class SingletonDCL {

  private static volatile SingletonDCL instance = null;

  private SingletonDCL() {}

  public static SingletonDCL getInstance() {
    if (instance == null) { // 1
      synchronized (SingletonDCL.class) { // 2
        if (instance == null) {
          instance = new SingletonDCL();
        }
      }
    }

    return instance;
  }

  // 说明
  // 校验锁1：第1个if
  // 作用：若单例已创建，则直接返回已创建的单例，无需再执行加锁操作
  // 即直接跳到执行 return ourInstance

  // 校验锁2：第2个 if
  // 作用：防止多次创建单例问题
  // 原理
  // 1. 线程A调用getInstance()，当运行到②位置时，此时线程B也调用了getInstance()
  // 2. 因线程A并没有执行instance = new Singleton();，此时instance仍为空，因此线程B能突破第1层 if
  // 判断，运行到①位置等待synchronized中的A线程执行完毕
  // 3. 当线程A释放同步锁时，单例已创建，即instance已非空
  // 4. 此时线程B 从①开始执行到位置②。此时第2层 if 判断 = 为空（单例已创建），因此也不会创建多余的实例
}

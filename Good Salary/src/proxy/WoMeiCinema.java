package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 作者：王文彬 on 2019-05-14 17：33 邮箱：wwb199055@126.com */
public class WoMeiCinema implements InvocationHandler {

  private Object object;

  public WoMeiCinema(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    guanggao(true);
    if (method.getName().equals("play")) {
      String name = (String) args[0];
      return method.invoke(object, args);
    }
    return null;
  }

  public void guanggao(boolean isStart) {
    if (isStart) {
      System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
    } else {
      System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
    }
  }
}

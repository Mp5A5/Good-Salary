package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 作者：王文彬 on 2019-05-14 15：54 邮箱：wwb199055@126.com */
public class GuitaiA implements InvocationHandler {
  private Object pingpai;

  public GuitaiA(Object pingpai) {
    this.pingpai = pingpai;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.println("销售开始  柜台是： "+this.getClass().getSimpleName());
      method.invoke(pingpai, args);
      System.out.println("销售结束");
    return null;
  }
}

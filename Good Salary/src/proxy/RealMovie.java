package proxy;

/** 作者：王文彬 on 2019-05-14 15：45 邮箱：wwb199055@126.com */
public class RealMovie implements Movie {
  @Override
  public void play(String name) {
    System.out.println("您正在观看电影: " + name);
  }
}

package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/** 作者：王文彬 on 2019-05-14 15：49 邮箱：wwb199055@126.com */
public class ProxyTest {

  public static void main(String[] args) {
    /*RealMovie realMovie = new RealMovie();
    Movie m = new Cinema(realMovie);
    m.play("《肖申克的救赎》");

    MaotaiJiu maotaijiu = new MaotaiJiu();
    Wuliangye wuliangye = new Wuliangye();
    InvocationHandler handler = new GuitaiA(maotaijiu);
    InvocationHandler handler1 = new GuitaiA(wuliangye);
    SellWine sellWine =
        (SellWine)
            Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(), MaotaiJiu.class.getInterfaces(), handler);
    SellWine sellWine1 =
        (SellWine)
            Proxy.newProxyInstance(
                MaotaiJiu.class.getClassLoader(), MaotaiJiu.class.getInterfaces(), handler1);
    sellWine.mainJiu();
    sellWine1.mainJiu();*/


      RealMovie realMovie = new RealMovie();
      WoMeiCinema cinema = new WoMeiCinema(realMovie);
      Movie movie = (Movie) Proxy.newProxyInstance(realMovie.getClass().getClassLoader(),realMovie.getClass().getInterfaces(),cinema);
      movie.play("《肖申克的救赎》");
  }
}

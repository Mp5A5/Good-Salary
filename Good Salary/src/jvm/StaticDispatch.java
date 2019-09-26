package jvm;

/** 作者：王文彬 on 2019/9/9 17：58 邮箱：wwb199055@126.com */

/** 重载方法在编译器就可以进行确定，不需要等到运行期间 */
public class StaticDispatch {

  static class Human {}

  static class Women extends Human {}

  static class Men extends Human {}

  public void sayHello(Human human) {
    System.out.println("say human");
  }

  public void sayHello(Women women) {
    System.out.println("say women");
  }

  public void sayHello(Men men) {
    System.out.println("say men");
  }

  public static void main(String[] args) {

    StaticDispatch ds = new StaticDispatch();

    Human women = new Women();

    Human men = new Men();

    ds.sayHello(women);

    ds.sayHello(men);
  }
}

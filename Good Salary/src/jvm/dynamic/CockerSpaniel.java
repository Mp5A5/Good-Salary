package jvm.dynamic;

/** 作者：王文彬 on 2019/9/9 18：52 邮箱：wwb199055@126.com */
public class CockerSpaniel extends Dog implements Friendly {

  private int woofCount = ((int) (Math.random() * 4.0)) + 1;

  private int wimperCount = ((int) (Math.random() * 3.0)) + 1;

  @Override
  public void sayHello() {
    super.sayHello();
    System.out.println("Woof");
    for (int i = 0; i < woofCount; i++) {
      System.out.println(", woof");
    }
  }

  @Override
  public void sayGoodbye() {
    System.out.println("Wimper");
    for (int i = 0; i < wimperCount; i++) {
      System.out.println(", wimper");
    }
  }
}


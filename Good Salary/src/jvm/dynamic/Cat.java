package jvm.dynamic;

/** 作者：王文彬 on 2019/9/9 18：51 邮箱：wwb199055@126.com */
public class Cat implements Friendly {

  public void eat() {
    System.out.println("Chomp, chomp, chomp");
  }

  @Override
  public void sayHello() {
    System.out.println("Rub, rub, rub");
  }

  @Override
  public void sayGoodbye() {
    System.out.println("Samper");
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("Meow");
  }
}

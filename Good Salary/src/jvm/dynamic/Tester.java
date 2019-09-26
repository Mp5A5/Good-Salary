package jvm.dynamic;

/** 作者：王文彬 on 2019/9/9 19：03 邮箱：wwb199055@126.com */
public class Tester {
  public static void main(String[] args) {

    Dog dog = new CockerSpaniel();

    dog.sayHello();

    Friendly fr = (Friendly) dog;

    fr.sayGoodbye();

    fr = new Cat();

    fr.sayGoodbye();
  }
}

package recover;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-06-21 07：49 邮箱：wwb199055@126.com */
public class Polymorphism {

  class A {
    private void sya() {
      System.out.println("a say");
    }
  }

  class B extends A {
    public void sya() {
      System.out.println("b say");
    }
  }

  @Test
  public void main() {
    A a = new B();
    a.sya();
  }
}

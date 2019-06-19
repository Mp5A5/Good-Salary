package recover;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-05-10 13：43 邮箱：wwb199055@126.com */
public class Java_08_01_final {

  class A {
    protected final void getName() {}

    private void getAge() {
      System.out.println("A age");
    }
  }

  class B extends A {


    private void getAge() {
      System.out.println("B age");
    }
  }

  @Test
  public void test() {
    A a = new B();
    a.getAge();
  }
}

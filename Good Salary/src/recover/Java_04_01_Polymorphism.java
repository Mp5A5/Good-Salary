package recover;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-04-30 15：24 邮箱：wwb199055@126.com */
public class Java_04_01_Polymorphism {

  public class A {
    public String show(D obj) {
      return ("A and D");
    }

    public String show(A obj) {
      return ("A and A");
    }
  }

  public class B extends A {
    public String show(B obj) {
      return ("B and B");
    }

    @Override
    public String show(A obj) {
      return ("B and A");
    }
  }

  public class C extends B {}

  public class D extends B {}

  @Test
  public void test() {
    A a1 = new A();//A
    A a2 = new B();//B
    B b = new B();//B
    C c = new C();//C
    D d = new D();//D
    //c>b>a
    //d>b>a
    System.out.println("1--" + a1.show(b));
    System.out.println("2--" + a1.show(c));
    System.out.println("3--" + a1.show(d));
    System.out.println("4--" + a2.show(b));
    System.out.println("5--" + a2.show(c));
    System.out.println("6--" + a2.show(d));
    System.out.println("7--" + b.show(b));
    System.out.println("8--" + b.show(c));
    System.out.println("9--" + b.show(d));
  }
}

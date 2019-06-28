package enumset;

/** 作者：王文彬 on 2019-06-22 18：55 邮箱：wwb199055@126.com */
public enum MyEnum {
  A {
    void doSomething() {
      System.out.println("a");
    }
  },

  B {
    void doSomethingElse() {
      System.out.println("B");
    }
  },
  C;
}

package jvm;

/** 作者：王文彬 on 2019/9/9 18：09 邮箱：wwb199055@126.com */
public class DynamicDispatch {

  abstract static class Human {
    public abstract void sayHello();
  }

  static class Women extends Human {

    @Override
    public void sayHello() {
      System.out.println("say women");
    }
  }

  static class Men extends Human {

    @Override
    public void sayHello() {
      System.out.println("say men");
    }
  }

  public static void main(String[] args) {
    Human women = new Women();

    Human men = new Men();

    women.sayHello();

    men.sayHello();
  }
}

package recover;

/** 作者：王文彬 on 2019-05-17 15：30 邮箱：wwb199055@126.com */
public class DynamicDispatch {

  abstract static class Human {
    protected abstract void sayHello();
  }

  static class Man extends Human {
    @Override
    protected void sayHello() {
      System.out.println("man say hello");
    }
  }

  static class Woman extends Human {
    @Override
    protected void sayHello() {
      System.out.println("woman say hello");
    }
  }

  public static void main(String[] args) {
    Human man = new Man();
    Human woman = new Woman();
    man.sayHello(); // man say hello
    woman.sayHello(); // woman say hello
  }
}

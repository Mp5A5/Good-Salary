package recover;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class Java_13_02_Static {

  private A a = new A();

  static {
    System.out.println("Static");
  }

  {
    System.out.println('a');
  }

  public Java_13_02_Static() {
    System.out.println("Constructor");
  }
}


class A{
  public A() {
    System.out.println('A');
  }
}

 class TestS{

  public static void main(String[] args) {
    Java_13_02_Static aStatic = new Java_13_02_Static();
  }
}

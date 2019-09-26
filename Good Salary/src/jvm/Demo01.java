package jvm;

/** 作者：王文彬 on 2019/9/9 10：35 邮箱：wwb199055@126.com */
public class Demo01 {

  static {
    System.out.println("初始化Demo01");
  }

  public static void main(String[] args) {

    System.out.println("Demo01的main方法");

    A a = new A();

    System.out.println(a.width);

    A a1 = new A();

  }
}

class A extends A_father {

  public static int width = 100;

  static {
    System.out.println("初始化A类静态区");

    width = 300;
  }

  public A() {
    System.out.println("创建A类对象");
  }
}

class A_father {

  static {
    System.out.println("初始化A_father类静态区");
  }
}

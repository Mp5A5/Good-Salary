package recover;

/** 作者：王文彬 on 2019-05-06 10：43 邮箱：wwb199055@126.com */
public class java_06_04_static_test extends java_06_01_static {

  public static void main(String[] args) {

    java_06_03_static aStatic = new java_06_03_static();
    System.out.println(aStatic.nonStaticStr);
    System.out.println(aStatic.staticStr);
    aStatic.nonStaticMethod();

    System.out.println("-------------------------------");

    java_06_01_static c1 = new java_06_03_static();
    System.out.println(c1.nonStaticStr);
    System.out.println(c1.staticStr);
    c1.staticMethod(); // 结果同上，输出的结果都是父类中的非静态属性、静态属性和静态方法,推出静态属性和静态方法可以被继承

    System.out.println("-------------------------------");

    java_06_02_static b = new java_06_02_static();
    System.out.println(b.nonStaticStr);
    System.out.println(b.staticStr);
    b.staticMethod();

    System.out.println("-------------------------------");

    java_06_01_static b1 = new java_06_02_static();
    System.out.println(b1.nonStaticStr);
    System.out.println(b1.staticStr);
    b1.staticMethod(); // 结果都是父类的静态方法，说明静态方法不可以被重写，不能实现多态
  }
}

package jvm.dynamic;

/** 作者：王文彬 on 2019/9/9 18：50 邮箱：wwb199055@126.com */
public class Dog {

  private int wagCount = ((int) (Math.random() * 5.0)) + 1;

  public void sayHello() {
    System.out.println("Wag");
    for (int i = 0; i < wagCount; i++) System.out.println(", wag");
  }

  public String toString() {
    return "Woof";
  }
}

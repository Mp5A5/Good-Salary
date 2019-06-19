package recover;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-05-14 10：39 邮箱：wwb199055@126.com */
public class Java_10_01_InnerClass {

  class Bar {

    public void show() {
      // do ..
    }
  }

  @Test
  public void test() {
    Java_10_01_InnerClass innerDemo01 = new Java_10_01_InnerClass();
    Bar bar = innerDemo01.method();
    bar.show(); // 你觉得num会输出吗？？？？
  }

  private Bar method() {
    String str = "mp5a5";
    int num = 30;

    // 局部内部类将输出这个局部变量
    class innerClass extends Bar {

      public void show() {
        System.out.println(num);
      }
    }

    return new innerClass();
  }
}

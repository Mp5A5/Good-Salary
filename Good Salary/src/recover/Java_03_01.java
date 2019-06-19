package recover;

/** 作者：王文彬 on 2019-04-26 17：21 邮箱：wwb199055@126.com */
public class Java_03_01 {

  public static class Wine {

    public void fun1() {
      System.out.println("Wine 的 fun1.....");
      fun2();
    }

    public void fun2() {
      System.out.println("Wine 的fun2...");
    }
  }

  public static class JNC extends Wine {

    /** 子类重载父类方法 父类中不存在该方法，向上转型后，父类是不能引用该方法的 */
    public void fun1(String a) {
      System.out.println("JNC 的 Fun1...");
      fun2();
    }

    /** 子类重写父类方法 指向子类的父类引用调用fun2时，必定是调用该方法 */
    @Override
    public void fun2() {
      System.out.println("JNC 的Fun2...");
    }
  }

  public static void main(String[] args) {
    Wine wine = new JNC();
    JNC j = new JNC();
    j.fun1("af");
    j.fun1();
  }
}

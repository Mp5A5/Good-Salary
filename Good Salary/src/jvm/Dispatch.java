package jvm;

/** 作者：王文彬 on 2019/9/9 18：13 邮箱：wwb199055@126.com */
public class Dispatch {

  static class QQ {};

  static class _360 {};

  public static class Father {

    public void hardChoice(QQ arg) {
      System.out.println("father choose qq");
    }

    public void hardChoice(_360 arg) {
      System.out.println("father choose 360");
    }
  }

  public static class Son extends Father {
    public void hardChoice(QQ arg) {
      System.out.println("son choose qq");
    }

    public void hardChoice(_360 arg) {
      System.out.println("son choose 360");
    }
  }

  public static void main(String[] args) {
    Father father = new Father();
    Father son = new Son();
    father.hardChoice(new _360());
    son.hardChoice(new QQ());
  }
}

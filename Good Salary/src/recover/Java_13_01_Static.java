package recover;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class Java_13_01_Static {

  public static void main(String[] args) {

    System.out.println("create new cupboard in main -----------");
    new Cupboard();
    System.out.println("create new cupboard in main");
    new Cupboard();
    table.f2(1);
    cupboard.f3(1);
  }

  static Table table = new Table();
  static Cupboard cupboard = new Cupboard();
}

class Bowl {

  public Bowl(int marker) {
    System.out.println("Bowl：" + marker);
  }

  public void f1(int marker) {
    System.out.println("f1：" + marker);
  }
}

class Table {

  static Bowl bowl1 = new Bowl(1);

  public Table() {
    System.out.println("Table()");
    bowl2.f1(1);
  }

  public void f2(int marker) {
    System.out.println("f2：" + marker);
  }

  static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
  Bowl bowl3 = new Bowl(3);
  static Bowl bowl4 = new Bowl(4);

  public Cupboard() {
    System.out.println("Cupboard");
    bowl4.f1(2);
  }

  void f3(int marker) {
    System.out.println("f3：" + marker);
  }

  static Bowl bowl5 = new Bowl(5);
}

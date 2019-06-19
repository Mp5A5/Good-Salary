package recover;

/** 作者：王文彬 on 2019-05-03 11：36 邮箱：wwb199055@126.com */
public class Java_05_02_InnerClass {
  //一般内部类--------------------------------------------------------------------------------------------------
  public int outField1 = 1;
  protected int outField2 = 2;
  int outField3 = 3;
  private int outField4 = 4;

  public Java_05_02_InnerClass() {
    // 在外部类对象内部，直接通过 new InnerClass(); 创建内部类对象
    InnerClassA innerObj = new InnerClassA();
    System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
    System.out.println("其内部类的 field1 字段的值为: " + innerObj.field1);
    System.out.println("其内部类的 field2 字段的值为: " + innerObj.field2);
    System.out.println("其内部类的 field3 字段的值为: " + innerObj.field3);
    System.out.println("其内部类的 field4 字段的值为: " + innerObj.field4);
  }


  public class InnerClassA {
    public int field1 = 5;
    protected int field2 = 6;
    int field3 = 7;
    private int field4 = 8;
    //    static int field5 = 5; // 编译错误！普通内部类中不能定义 static 属性

    public InnerClassA() {
      System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
      System.out.println("其外部类的 outField1 字段的值为: " + outField1);
      System.out.println("其外部类的 outField2 字段的值为: " + outField2);
      System.out.println("其外部类的 outField3 字段的值为: " + outField3);
      System.out.println("其外部类的 outField4 字段的值为: " + outField4);
    }


  }

  public static void main(String[] args) {
    Java_05_01_InnerClass outerObj = new Java_05_01_InnerClass();
    // 不在外部类内部，使用：外部类对象. new 内部类构造器(); 的方式创建内部类对象
    //InnerClassA innerObj = outerObj.new InnerClassA();
  }


}

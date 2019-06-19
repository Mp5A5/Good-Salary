package recover;

/** 作者：王文彬 on 2019-05-03 11：36 邮箱：wwb199055@126.com */
public class Java_05_01_InnerClass {
  /*
  一般内部类--------------------------------------------------------------------------------------------------
  public int outField1 = 1;
  protected int outField2 = 2;
  int outField3 = 3;
  private int outField4 = 4;

  public recover.Java_05_01_InnerClass() {
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
    recover.Java_05_01_InnerClass outerObj = new recover.Java_05_01_InnerClass();
    // 不在外部类内部，使用：外部类对象. new 内部类构造器(); 的方式创建内部类对象
    //InnerClassA innerObj = outerObj.new InnerClassA();
  }*/

  /*
  静态内部类--------------------------------------------------------------------------------------------------
  public int outField1 = 1;

  public recover.Java_05_01_InnerClass() {
    System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
    // 创建静态内部类对象
    StaticClass innerObj = new StaticClass();
    System.out.println("其内部类的 field1 字段的值为: " + innerObj.field1);
    System.out.println("其内部类的 field2 字段的值为: " + innerObj.field2);
    System.out.println("其内部类的 field3 字段的值为: " + innerObj.field3);
    System.out.println("其内部类的 field4 字段的值为: " + innerObj.field4);
  }

  static class StaticClass {

    public int field1 = 1;
    protected int field2 = 2;
    int field3 = 3;
    private int field4 = 4;
    // 静态内部类中可以定义 static 属性
    static int field5 = 5;

    public StaticClass() {
      System.out.println("创建 " + StaticClass.class.getSimpleName() + " 对象");
      //System.out.println("其外部类的 field1 字段的值为: " + outField1); // 编译错误！！
    }
  }

  public static void main(String[] args) {
    // 无需依赖外部类对象，直接创建内部类对象
    recover.Java_05_01_InnerClass.StaticClass staticClassObj = new recover.Java_05_01_InnerClass.StaticClass();
//    recover.Java_05_01_InnerClass outerObj = new recover.Java_05_01_InnerClass();
  }*/


 /* //匿名内部类--------------------------------------------------------------------------------------------------
  public int field1 = 1;
  protected int field2 = 2;
  int field3 = 3;
  private int field4 = 4;

  public recover.Java_05_01_InnerClass() {
    System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
  }
  // 自定义接口
  interface OnClickListener {
    void onClick(Object obj);
  }

  private void anonymousClassTest() {
    // 在这个过程中会新建一个匿名内部类对象，
    // 这个匿名内部类实现了 OnClickListener 接口并重写 onClick 方法
    OnClickListener clickListener =
        new OnClickListener() {
          // 可以在内部类中定义属性，但是只能在当前内部类中使用，
          // 无法在外部类中使用，因为外部类无法获取当前匿名内部类的类名，
          // 也就无法创建匿名内部类的对象
          int field = 1;

          @Override
          public void onClick(Object obj) {
            System.out.println("对象 " + obj + " 被点击");
            System.out.println("其外部类的 field1 字段的值为: " + field1);
            System.out.println("其外部类的 field2 字段的值为: " + field2);
            System.out.println("其外部类的 field3 字段的值为: " + field3);
            System.out.println("其外部类的 field4 字段的值为: " + field4);
          }
        };
    // new Object() 过程会新建一个匿名内部类，继承于 Object 类，
    // 并重写了 toString() 方法
    clickListener.onClick(
        new Object() {
          @Override
          public String toString() {
            return "obj1";
          }
        });
}
  public static void main(String[] args) {
    recover.Java_05_01_InnerClass outObj = new recover.Java_05_01_InnerClass();
    outObj.anonymousClassTest();
  }*/



    public int field1 = 1;
    protected int field2 = 2;
    int field3 = 3;
    private int field4 = 4;

    public Java_05_01_InnerClass() {
        System.out.println("创建 " + this.getClass().getSimpleName() + " 对象");
    }

    private void localInnerClassTest() {
        // 局部内部类 A，只能在当前方法中使用
        class A {
            // static int field = 1; // 编译错误！局部内部类中不能定义 static 字段
            public A() {
                System.out.println("创建 " + A.class.getSimpleName() + " 对象");
                System.out.println("其外部类的 field1 字段的值为: " + field1);
                System.out.println("其外部类的 field2 字段的值为: " + field2);
                System.out.println("其外部类的 field3 字段的值为: " + field3);
                System.out.println("其外部类的 field4 字段的值为: " + field4);
            }
        }
        A a = new A();
        if (true) {
            // 局部内部类 B，只能在当前代码块中使用
            class B {

                public B() {
                    System.out.println("创建 " + B.class.getSimpleName() + " 对象");
                    System.out.println("其外部类的 field1 字段的值为: " + field1);
                    System.out.println("其外部类的 field2 字段的值为: " + field2);
                    System.out.println("其外部类的 field3 字段的值为: " + field3);
                    System.out.println("其外部类的 field4 字段的值为: " + field4);
                }
            }
            B b = new B();
        }
       //B b1 = new B(); // 编译错误！不在类 B 的定义域内，找不到类 B，
    }

    public static void main(String[] args) {
        Java_05_01_InnerClass outObj = new Java_05_01_InnerClass();
        outObj.localInnerClassTest();
    }

}

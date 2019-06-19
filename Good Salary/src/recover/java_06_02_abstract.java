package recover;

/** 作者：王文彬 on 2019-05-06 10：43 邮箱：wwb199055@126.com */
public class java_06_02_abstract extends java_06_01_abstract {


  @Override
  void open() {}

  @Override
  public String name() {
    return mName;
  }


  public static void main(String[] args) {
    java_06_02_abstract java_06_02_abstract = new java_06_02_abstract();
    System.out.println(java_06_02_abstract.name());
  }
}

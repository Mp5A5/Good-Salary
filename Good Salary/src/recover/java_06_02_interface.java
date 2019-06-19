package recover;

/** 作者：王文彬 on 2019-05-06 10：43 邮箱：wwb199055@126.com */
public class java_06_02_interface implements java_06_01_interface {


  @Override
  public void open() {
    System.out.println("open");
  }

  @Override
  public String name() {
    return java_06_01_interface.getName();
  }



  public static void main(String[] args) {
    java_06_02_interface java_06_02_interface = new java_06_02_interface();
    System.out.println(java_06_02_interface.name());
  }
}

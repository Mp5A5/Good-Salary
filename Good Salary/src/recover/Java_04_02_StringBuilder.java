package recover;

/** 作者：王文彬 on 2019-04-30 15：24 邮箱：wwb199055@126.com */
public class Java_04_02_StringBuilder {

  public static void main(String[] args) {
    String str="a5";
    StringBuilder builder = new StringBuilder("mp5");
    builder.append(str);

    System.out.println(builder.toString());
  }
}

package recover;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class Java_11_02_JVM {

  public static void main(String[] args) {
    int a = 1;
    int b = 2;
    int c = calc(a,b);
  }

  private static int calc(int a, int b) {
    return (int) Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
  }
}

package think_in_java;

/**
 * 作者：王文彬 on 2019-06-27 07：52
 * 邮箱：wwb199055@126.com
 */
public class Test {

  public static void main(String[] args) {
      Shared shared = new Shared();

      Composing[] composings = {new Composing(shared),new Composing(shared),new Composing(shared),new Composing(shared),new Composing(shared)};

    for (Composing composing : composings) {
        composing.dispose();
    }
  }
}

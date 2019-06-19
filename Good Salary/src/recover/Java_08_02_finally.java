package recover;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

/** 作者：王文彬 on 2019-05-10 13：43 邮箱：wwb199055@126.com */
public class Java_08_02_finally {

  @Test
  public void test() {
    System.out.println("run of getInt() value:" + getInt());
  }

  private int getInt() {
    int i = 1;
    System.out.println("try catch block");
    try {
      System.out.println("try block");
      System.exit(0);
      return i;
    } finally {
      System.out.println("finally block");
    }
  }
}

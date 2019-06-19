package recover;

import javafx.embed.swt.SWTFXUtils;

import java.util.Random;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class Java_12_01_JVM {

  public static void main(String[] args) {
    /*int i = 0;
    outer:
    for (; true; ) {
      inner:
      for (; i < 10; i++) {

      }
    }*/

    int i=0;

    Random random = new Random();
    int i1 = random.nextInt(10);
    System.out.println(i1);
  }
}

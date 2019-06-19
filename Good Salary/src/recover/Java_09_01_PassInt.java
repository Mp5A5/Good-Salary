package recover;

/** 作者：王文彬 on 2019-05-11 11：21 邮箱：wwb199055@126.com */
public class Java_09_01_PassInt {

  public static void main(String[] args) {
    System.out.println(Integer.parseInt("ab", 16));
    System.out.println((int)'a');
    System.out.println(Character.digit('a',10));
    ;
    /*for (char c = '\u0001'; c <= '\u8c9f'; c++) {
      System.out.println(c);
    }*/

    System.out.println((-(Integer.MAX_VALUE))/10);
    //System.out.println(Integer.MIN_VALUE);
  }
}

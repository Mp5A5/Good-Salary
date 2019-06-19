package recover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 作者：王文彬 on 2019-04-25 15：13 邮箱：wwb199055@126.com */
public class Java_02_01 {

  public static void main(String[] args) {

    Integer integer = new Integer(3);
    Integer integer0 = new Integer(3);

    Integer integer1 = 3;
    Integer integer2 = 3;

    if (integer == integer0) System.out.println("integer == integer0");
    else System.out.println("integer != integer0");

    if (integer1 == integer2) System.out.println("integer1 == integer2");
    else System.out.println("integer1 != integer2");

    Integer integer3 = 300;
    Integer integer4 = 300;

    if (integer3 == integer4) System.out.println("integer3 == integer4");
    else System.out.println("integer3 != integer4");
  }
}

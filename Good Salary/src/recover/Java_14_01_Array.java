package recover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class Java_14_01_Array {

  public static void main(String[] args) {

    /*int[] a1 = {1, 2, 3, 4, 5};
    int[] a2;
    a2 = a1;

    a2[1] = 6;
    for (int i : a1) {
      System.out.println(i);
    }

    for (int i : a2) {
      System.out.println("a2: " + i);
    }*/

    List<Integer> l1 = new ArrayList<>();
    l1.add(0);
    l1.add(1);
    l1.add(2);
    l1.add(3);
    List<Integer> l2 = null;
    l2 = l1;
    l2.set(1, 5);
    l1.forEach(integer -> System.out.println("li:" + integer));
    l2.forEach(integer -> System.out.println("l2: " + integer));

    System.out.println();
    System.out.println("l2 = " + l2);
    System.out.println("l2 = " + l2);
  }

  public class B {}
}

 class C {}

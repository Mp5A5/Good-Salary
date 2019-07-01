package array_list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 作者：王文彬 on 2019-06-27 21：51 邮箱：wwb199055@126.com */
public class Test {

  public static void main(String[] args) {
    /*Object[] a = {1, 2, 3};
    Object[] objects = Arrays.copyOf(a, a.length, Object[].class);
    System.out.println(Arrays.toString(objects));

      ArrayList<Integer> objects1 = new ArrayList<>(3);
      objects1.add(1);
      objects1.add(1);
      objects1.add(1);
      ArrayList<Integer> integers = new ArrayList<>(objects1);*/

    ArrayList<String> list = new ArrayList<>(5);
    /*list.add("帅");
    list.add("帅");
    list.add("帅");*/
    // list.ensureCapacity(3);

    // System.out.println(Arrays.toString(list.toArray()));

    /*String[] a= {"w","a","n","g","H"};
    Object[] objects = list.toArray(a);
    System.out.println(Arrays.toString(objects));*/

    for (int i = 0; i < 5; i++) {
      list.add("mp5a5");
    }

    list.add("wang");

    // int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    String[] a = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", null, null};

    System.arraycopy(a, 3, a, 4, 7);

    a[3] = "x";

    System.out.println(Arrays.toString(a));
  }
}

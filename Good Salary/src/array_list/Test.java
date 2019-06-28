package array_list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

    ArrayList<String> list = new ArrayList<>();
    list.add("帅");
    list.ensureCapacity(3);

    //System.out.println(Arrays.toString(list.toArray()));
  }
}

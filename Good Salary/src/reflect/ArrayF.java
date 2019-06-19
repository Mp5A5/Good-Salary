package reflect;

import java.lang.reflect.Array;

/** 作者：王文彬 on 2019-05-22 16：18 邮箱：wwb199055@126.com */
public class ArrayF {
  public static void main(String[] args) {
    // 用反射创建 int[] array = new int[]{1, 2}
    Object instance = Array.newInstance(int.class, 2);
    Array.setInt(instance, 0, 1);
    Array.setInt(instance, 1, 2);
    System.out.println(instance.getClass().getSimpleName());
  }
}

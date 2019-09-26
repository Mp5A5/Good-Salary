package collection;

import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Integer.toBinaryString;

/** 作者：王文彬 on 2019-07-26 08：07 邮箱：wwb199055@126.com */
public class HashTest {

  private volatile int mINt = 100;

  private static Object[] mBigArray;

  private static Object[] mBaseCache;

  public static void main(String[] args) {
    /*final int max = Integer.MAX_VALUE >>> 4;
    Random random = new Random(System.currentTimeMillis());
    for (int i = 0; i < 20; i++) {
      int hash = random.nextInt(max) << 4;
      int betterHash = hash ^ (hash >>> 16);
      System.out.print(toBinaryString(hash));
      System.out.println("-->" + toBinaryString(betterHash));*/

    /*Map<String,Integer> map = new HashMap<>();
    map.put("a",1);
    map.put("b",2);
    map.put("c",3);

    //HashMap<String, Integer> stringIntegerHashMap = new HashMap<>(map);

    Unsafe unsafe = Unsafe.getUnsafe();*/

    /*System.out.println(Integer.numberOfLeadingZeros(64));

    LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
    map.remove("a");*/

    Object[] mArray = new Object[2];

    int[] ints = {0, 1, 2, 3};

    Object[] objects = {"a", 3, "5"};

    mArray[0] = ints;

    mArray[1] = objects;

    mBigArray = mArray;

    final Object[] array = mBigArray;

    mBaseCache = (Object[]) array[1];

    array[0] = null;

    System.out.println(Arrays.toString((int[]) array[0]));
    System.out.println(Arrays.toString((int[]) mBigArray[0]));
    System.out.println(Arrays.toString(mBaseCache));

    System.out.println(~-1);

  }
}

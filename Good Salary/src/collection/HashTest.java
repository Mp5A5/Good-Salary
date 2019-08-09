package collection;

import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Integer.toBinaryString;

/** 作者：王文彬 on 2019-07-26 08：07 邮箱：wwb199055@126.com */
public class HashTest {

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

    System.out.println(Integer.numberOfLeadingZeros(64) | (1 << (16 - 1)));
    /*System.out.println(Integer.numberOfLeadingZeros(16));*/

    int i = Integer.numberOfLeadingZeros(16) | (1 << (16 - 1));

    System.out.println(16 >>> 3);

    /*int stride;
    int NCPU = 3;
    int n = 16;
    int MIN_TRANSFER_STRIDE = 16;

    if ((stride = (NCPU > 1) ? (n >>> 3) / NCPU : n)< MIN_TRANSFER_STRIDE) ;*/

   for (int j=0;;){
     j++;
     if (j==5){
       return;
     }
      System.out.println(j);
   }
  }
}

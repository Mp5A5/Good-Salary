package recover;

import java.util.HashMap;
import java.util.Map;

/** 作者：王文彬 on 2019-04-25 15：13 邮箱：wwb199055@126.com */
public class Java_02 {

  public static void main(String[] args) {
    /*Key k1 = new Key(1);
    Key k2 = new Key(1);
    Map<Key, String> map = new HashMap<>();
    map.put(k1, "Key with id is 1");
    System.out.println(map.get(k2));

    int i = Integer.MAX_VALUE;
    int j = Integer.MAX_VALUE;

    int k = i + j;
    System.out.println("i (" + i + ") + j (" + j + ") = k (" + k + ")");*/


    Map<String,Boolean> map =  new HashMap<String, Boolean>();
    Boolean b = (map!=null ? map.get("test") : false);
    System.out.println(b);
  }
}

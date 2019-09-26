import java.util.*;

/** 作者：王文彬 on 2019/9/25 17：14 邮箱：wwb199055@126.com */
public class Test {

  public static void main(String[] args) {
    LinkedHashMap<String,Integer> map = new LinkedHashMap<>(12,0.75f,true);
    map.put("a",1);
    map.put("b",2);
    map.put("c",3);
    map.put("d",4);
    map.put("e",5);
    map.put("c",6);

    Map.Entry<String,Integer> toEvict = null;
    for (Map.Entry<String,Integer> entry : map.entrySet()) {
      toEvict = entry;
    }
    System.out.println(toEvict.getValue());

    map.remove(toEvict.getKey());

    System.out.println(map.toString());

    int c = map.get("b");

    System.out.println(map.toString());
  }
}

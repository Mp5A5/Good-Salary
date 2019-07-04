package linked_list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 作者：王文彬 on 2019-07-05 00：48
 * 邮箱：wwb199055@126.com
 */
public class Test {

  public static void main(String[] args) {
      Deque<Integer> deque = new LinkedList<>();

      deque.push(1);
      deque.push(2);
      deque.push(3);
      deque.push(4);

      deque.pop();

    System.out.println(deque.toString());


    List<String> list = new LinkedList<>();
    list.add("1");
    list.add(null);
    //list.add("2");
    System.out.println(list.size());
   }
}

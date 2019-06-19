package collection;

import java.util.*;

/** 作者：王文彬 on 2019-06-13 15：03 邮箱：wwb199055@126.com */
public class Test {

  public static void main(String[] args) {
    AbstractList abstractList = new ArrayList<String>();
    abstractList.add("a");
    abstractList.add("b");
    abstractList.add("c");
    abstractList.add("d");
    abstractList.add("e");
    System.out.println("原始集合:          " + abstractList.toString());

    List subList = abstractList.subList(1, 3);

    System.out.println("截取后集合:        " + subList);
    System.out.println("截取后原始集合:    " + abstractList);
    subList.add("我是后添加数据f");
    System.out.println("添加元素后原始集合:" + abstractList);
    System.out.println("截取后集合:        " + subList);
  }
}

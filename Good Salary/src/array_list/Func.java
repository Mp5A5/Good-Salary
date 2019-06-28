package array_list;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/** 作者：王文彬 on 2019-06-27 20：56 邮箱：wwb199055@126.com */
public class Func {


  public static void main(String[] args) {
    Function<Integer, Integer> function1 = x -> x * 2;

    System.out.println(function1.apply(4));

    UnaryOperator<Integer> operator = x -> x + 1;

    System.out.println(operator.apply(5));
  }
}

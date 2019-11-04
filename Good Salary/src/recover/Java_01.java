package recover;

import java.util.ArrayList;
import java.util.Arrays;

/** 作者：王文彬 on 2019-04-24 13：38 邮箱：wwb199055@126.com */
public class Java_01 {

  public static void main(String[] args) {
    int a = 10;
    long b = 10L;
    double c = 10.0;
    System.out.println(a==b);
//
//    P p1 = new  P("wang", 15);
//    P p2 = new  P("wang", 15);
//    System.out.println(p1.equals(p2));
//
//    char cha = 'c';
//    System.out.println();

    /*char A=1;
    char B=2;
    char C=33;
    String aString=String.valueOf(A)+String.valueOf(B);
    String bString=String.valueOf(C);
    System.out.println(aString);
    System.out.println(bString);
    System.out.println("aString length: " + aString.length());
    System.out.println("bString length: " + bString.length());
    System.out.println("aString equals bString: " + aString.equals(bString));
    System.out.println("aString hashCode: " + aString.hashCode());
    System.out.println("bString hashCode: " + bString.hashCode());*/

    /*int limit = -Integer.MAX_VALUE;
    System.out.println(limit);

    String s="21";

    System.out.println(s.charAt(0));

    int digit = Character.digit(s.charAt(0),10);

    char firstChar = s.charAt(0);
    System.out.println(firstChar);

    int result = s.charAt(0) - '0';

    System.out.println(result);

    System.out.println(new ArrayList<Integer>().getClass() == new ArrayList<String>().getClass());  // true*/

    int[] arr = {1,2,3,4,5};
    int [] temp = new int[10];
    System.arraycopy(arr,0,temp,0,5);
    System.out.println(Arrays.toString(temp));
  }
}

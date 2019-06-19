package recover;

/** 作者：王文彬 on 2019-04-24 13：38 邮箱：wwb199055@126.com */
public class Java_01 {

  public static void main(String[] args) {
//    int a = 10;
//    long b = 10L;
//    double c = 10.0;
//    System.out.println(a==b);
//
//    P p1 = new  P("wang", 15);
//    P p2 = new  P("wang", 15);
//    System.out.println(p1.equals(p2));
//
//    char cha = 'c';
//    System.out.println();

    char A=1;
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
    System.out.println("bString hashCode: " + bString.hashCode());

  }
}

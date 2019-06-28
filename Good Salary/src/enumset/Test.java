package enumset;

import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

import javax.sound.midi.Soundbank;
import java.util.EnumSet;

/** 作者：王文彬 on 2019-06-22 18：57 邮箱：wwb199055@126.com */
public class Test {

  public static void main(String[] args) {

    JavaLangAccess access = SharedSecrets.getJavaLangAccess();

    Throwable throwable = new Throwable();

    int depth = access.getStackTraceDepth(throwable);

    for (int i = 0; i < depth; i++) {
      StackTraceElement element = access.getStackTraceElement(throwable, i);
      System.out.println(element);
    }

    EnumSet<MyEnum> myEnums = EnumSet.noneOf(MyEnum.class);
    System.out.println(myEnums);
    for (MyEnum myEnum : myEnums) {
      System.out.println(myEnum);
    }

    MyEnum[] enums = access.getEnumConstantsShared(MyEnum.class);

    for (int i = 0; i < enums.length; i++) {
      System.out.println(enums[i]);
    }

    System.out.println(MyEnum.A.ordinal());

    System.out.println(Long.bitCount(3L));

    System.out.println(-1L>>>-68);//1000100
  }
}

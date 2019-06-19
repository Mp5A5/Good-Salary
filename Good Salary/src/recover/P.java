package recover;

import com.sun.istack.internal.Nullable;
import kotlin.jvm.internal.Intrinsics;

/** 作者：王文彬 on 2019-04-24 14：37 邮箱：wwb199055@126.com */
public class P {
  public int age;
  public String name;

  public P(String name, int age) {
    this.age = age;
    this.name = name;
  }

  @Override
  public boolean equals(@Nullable Object paramObject) {
    if (this != paramObject) {
      if ((paramObject instanceof P)) {
        P localP = (P) paramObject;
        if (Intrinsics.areEqual(this.name, localP.name)) {
          if ((this.age == localP.age ? 1 : 0) == 0) {}
        }
      }
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

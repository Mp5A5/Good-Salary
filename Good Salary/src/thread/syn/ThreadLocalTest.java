package thread.syn;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 作者：王文彬 on 2019/8/28 11：47 邮箱：wwb199055@126.com */
public class ThreadLocalTest {

  private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
      ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

  public static void main(String[] args) {

    new Thread(
            () -> {
              Date date = new Date();
              System.out.println(dateFormatThreadLocal.get().format(date));
            })
        .start();

    new Thread(
            () -> {
              Date date = new Date();
              System.out.println(dateFormatThreadLocal.get().format(date));
            })
        .start();
  }
}

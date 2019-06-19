package recover;

import org.junit.jupiter.api.Test;

/** 作者：王文彬 on 2019-05-10 13：43 邮箱：wwb199055@126.com */
public class Java_08_03_finally {

  @Test
  public void test() {
    System.out.println("run of getInt() value:" + getInt("0"));
  }

  private int getInt(String str) {
    try {
      return str.charAt(0) - '0';
    } catch (NullPointerException e) {
      return 1;
    } catch (StringIndexOutOfBoundsException e) {
      return 2;
    } catch (Exception e) {
      return 3;
    } finally {
      return 4;
    }
  }
}

package reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** 作者：王文彬 on 2019-05-21 18：12 邮箱：wwb199055@126.com */
public class TestReflection {
  private static final String TAG = "Reflection";

  @Test
  public void testReflection() {
    // 获取Animal类的Class对象
    Class c = Animal.class;
    try {
      // 通过Class对象反射获取Animal类的构造方法
      Constructor constructor = c.getConstructor(String.class, int.class);
      // 调用构造方法获取Animal实例
      Animal animal = (Animal) constructor.newInstance("Jack", 3);
      // 将构造出来的Animal对象打印出来
      System.out.println(animal.toString());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}

package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/** 作者：王文彬 on 2019-05-22 11：39 邮箱：wwb199055@126.com */
public class Member {

  /*

  public static void main(String[] args) {
    Class<?> clazz = Cat.class;
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      StringBuilder builder = new StringBuilder();
      // 获取名称
      builder.append("filed name = ");
      builder.append(field.getName());
      // 获取类型
      builder.append(" type = ");
      builder.append(field.getType());
      // 获取修饰符
      builder.append(" modifiers = ");
      builder.append(Modifier.toString(field.getModifiers()));
      // 获取注解
      Annotation[] annotations = field.getAnnotations();
      if (annotations.length != 0) {
        builder.append(" annotations = ");
        for (Annotation annotation : annotations) {
          builder.append(annotation.toString());
          builder.append(" ");
        }
      } else {
        builder.append("  -- No Annotations --");
      }
      System.out.println(builder.toString());
    }
  }*/

  /*public static void main(String[] args) {
    Cat cat = new Cat("Tom", 2);
    Class clazz = cat.getClass();
    try {
      // 注意获取private变量时，需要用getDeclaredField
      Field fieldName = clazz.getDeclaredField("name");
      fieldName.setAccessible(true);
      Field fieldAge = clazz.getField("age");
      // 反射获取名字, 年龄
      String name = (String) fieldName.get(cat);
      int age = fieldAge.getInt(cat);
      System.out.println("before set, Cat name = " + name + " age = " + age);
      // 反射重新set名字和年龄
      fieldName.set(cat, "mp5a5");
      fieldAge.set(cat, 29);
      System.out.println("after set, Cat " + cat.toString());
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }*/

  public static void main(String[] args) {
    Class<?> clazz = Cat.class;
    // 构造Cat实例
    try {
      Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
      Object instance = constructor.newInstance("Mp5a5", 28);
      System.out.println(instance);
      // 调用无参方法
      Method sleep = clazz.getMethod("sleep");
      sleep.invoke(instance);
      // 调用定项参数方法
      Method eat = clazz.getDeclaredMethod("eat", String.class);
      eat.invoke(instance, "吃饭");

      // 调用不定项参数方法
      // 不定项参数可以当成数组来处理
      Class[] classes = new Class[] {String[].class};
      Method eat1 = clazz.getDeclaredMethod("eat", classes);
      eat1.setAccessible(true);
      String[] foods = new String[] {"grass", "meat"};
      eat1.invoke(instance, (Object) foods);

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

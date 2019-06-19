package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/** 作者：王文彬 on 2019-05-22 11：08 邮箱：wwb199055@126.com */
public class Map {

  public static void main(String[] args) {
    Class<?> clazz = HashMap.class;
    // 获取类名
    System.out.println("Class:" + clazz.getCanonicalName());
    System.out.println("Class:" + clazz.getSimpleName());
    System.out.println("Class:" + clazz.getName());
    System.out.println("Class:" + clazz.getTypeName());
    System.out.println("Class:" + clazz.getSuperclass());
    System.out.println("Class:" + Arrays.stream(clazz.getInterfaces()).count());
    // 获取限定符
    System.out.println("Modifiers:" + Modifier.toString(clazz.getModifiers()));
    // 获取类泛型信息
    TypeVariable<? extends Class<?>>[] typeParameters = clazz.getTypeParameters();
    if (typeParameters.length != 0) {
      StringBuilder builder = new StringBuilder("Parameters : ");
      for (TypeVariable<? extends Class<?>> typeParameter : typeParameters) {
        builder.append(typeParameter.getName());
        builder.append(" ");
      }
      System.out.println(builder.toString());
    } else {
      System.out.println("  -- No Type Parameters --");
    }

    // 获取类实现的所有接口
    Type[] genericInterfaces = clazz.getGenericInterfaces();
    if (genericInterfaces.length != 0) {
      StringBuilder interfaces = new StringBuilder("Implemented Interfaces : ");
      for (Type genericInterface : genericInterfaces) {
        interfaces.append(genericInterface.toString());
        interfaces.append(" ");
      }
      System.out.println(interfaces.toString());
    } else {
      System.out.println("  -- Implemented Interfaces --");
    }

    // 获取类继承数上的所有父类
    List<Class> list = new LinkedList<>();
    printAncestor(clazz, list);
    if (list.size() != 0) {
      StringBuilder inheritance = new StringBuilder("Inheritance Path : ");
      for (Class aClass : list) {
        inheritance.append(aClass.getCanonicalName());
        inheritance.append(" ");
      }
      System.out.println(inheritance.toString());
    } else {
      System.out.println("  -- No Super Classes --%n%n");
    }

    // 获取类的注解(只能获取到 RUNTIME 类型的注解)
    Annotation[] annotations = clazz.getAnnotations();
    if (annotations.length != 0) {
      StringBuilder builder = new StringBuilder("Annotations : ");
      for (Annotation annotation : annotations) {
        builder.append(annotation.toString());
        builder.append(" ");
      }
      System.out.println(builder.toString());
    } else {
      System.out.println("  -- No Annotations --%n%n"  );
    }
  }

  private static void printAncestor(Class<?> clazz, List<Class> list) {
    Class<?> superclass = clazz.getSuperclass();
    if (superclass != null) {
      list.add(superclass);
      printAncestor(superclass, list);
    }
  }
}

package com.mp5a5.www.salary.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author ：mp5a5 on 2019-05-21 10：11
 * @describe ：执行具体绑定控件逻辑的api
 * @email ：wwb199055@126.com
 */
public class BindIdApi {

  public static void bindId(Activity obj) {
    Class<?> clazz = obj.getClass();
    //使用反射调用setContentView
    if (clazz.isAnnotationPresent(BindId.class)) {
      // 得到这个类的BindId注解
      BindId bindId = clazz.getAnnotation(BindId.class);
      // 得到注解的值
      int id = Objects.requireNonNull(bindId).value();
      try {
        Method method = clazz.getMethod("setContentView", int.class);
        method.setAccessible(true);
        method.invoke(obj, id);
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }
    // 使用反射调用findViewById
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(BindId.class)) {
        BindId bindId = field.getAnnotation(BindId.class);
        int id = bindId.value();
        try {
          Method method = clazz.getMethod("findViewById", int.class);
          method.setAccessible(true);
          Object view = method.invoke(obj, id);
          field.setAccessible(true);
          field.set(obj, view);
        } catch (NoSuchMethodException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void bindId2(Activity obj) {
    Class<?> clazz = obj.getClass();
    if (clazz.isAnnotationPresent(BindId.class)) {
      // 得到这个类的BindId注解
      BindId bindId = clazz.getAnnotation(BindId.class);
      int id = Objects.requireNonNull(bindId).value();
      obj.setContentView(id);
    }

    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(BindId.class)) {
        BindId bindId = field.getAnnotation(BindId.class);
        int id = bindId.value();
        View view = obj.findViewById(id);
        field.setAccessible(true);
        try {
          field.set(obj, view);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

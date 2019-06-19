package com.mp5a5.www.salary.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：mp5a5 on 2019-05-21 11：31
 * @describe ：
 * @email ：wwb199055@126.com
 */
public class OnClickApi {

  public static void bindOnClick(final Activity obj){
    Class<? > clazz = obj.getClass();
    //获取当前Activity的所有方法，包括私有
    Method[] methods = clazz.getDeclaredMethods();
    for (int i = 0; i < methods.length; i++) {
      // 得到这个类的OnClick注解
      final Method method = methods[i];
      if (method.isAnnotationPresent(OnClick.class)){
        OnClick onClick = method.getAnnotation(OnClick.class);
        // 得到注解的值
        int[] ids = onClick.value();
        for (int j = 0; j < ids.length; j++) {
          final View view = obj.findViewById(ids[j]);
          view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //反射指定的点击方法
              try{
                //私有方法需要设置true才能访问
                method.setAccessible(true);
                method.invoke(obj,view);
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              } catch (InvocationTargetException e) {
                e.printStackTrace();
              }
            }
          });
        }
      }
    }
  }
}

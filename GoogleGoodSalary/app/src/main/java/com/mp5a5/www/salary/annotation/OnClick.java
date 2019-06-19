package com.mp5a5.www.salary.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：mp5a5 on 2019-05-21 11：30
 * @describe ：
 * @email ：wwb199055@126.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnClick {
  int[] value();
}

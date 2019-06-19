package com.mp5a5.www.salary.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：mp5a5 on 2019-05-21 10：04
 * @describe : 绑定view的id或者layout的id，包含findViewById和setContentView两个功能
 * @email：wwb199055@126.com
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface BindId {
    int value() default View.NO_ID;
}

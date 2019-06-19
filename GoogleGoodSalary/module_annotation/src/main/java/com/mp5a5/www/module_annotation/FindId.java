package com.mp5a5.www.module_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：mp5a5 on 2019-05-21 15：53
 * @describe ：
 * @email ：wwb199055@126.com
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface FindId {
    int value();
}

package com.mp5a5.www.module_api;

import android.app.Activity;
import android.view.View;
import com.mp5a5.www.module_compiler.one.ProxyInfo;

import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：mp5a5 on 2019-05-21 17：18
 * @describe ：用来缓存反射出来的类，节省每次都去反射引起的性能问题
 * @email ：wwb199055@126.com
 */
public class TAHelper {
    static final Map<Class<?>, Constructor<?>> BINDINGS = new LinkedHashMap<>();

    public static void inject(Activity o) {
        inject(o, o.getWindow().getDecorView());
    }

    public static void inject(Activity host, View root) {
        String classFullName = host.getClass().getName() + ProxyInfo.ClassSuffix;
        try {
            Constructor constructor = BINDINGS.get(host.getClass());
            if (constructor == null) {
                Class proxy = Class.forName(classFullName);
                constructor = proxy.getDeclaredConstructor(host.getClass(), View.class);
                BINDINGS.put(host.getClass(), constructor);
            }
            constructor.setAccessible(true);
            constructor.newInstance(host, root);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}

package com.mp5a5.www.salary;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：mp5a5 on 2019-05-15 11：58
 * @describe
 * @email：wwb199055@126.com
 */
public class HookNotificationManager {

    public static void hookNotificationManager(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        try {

            @SuppressLint("PrivateApi") Method method = notificationManager.getClass().getDeclaredMethod("getService");
            method.setAccessible(true);
            //获取代理对象
            Object sService = method.invoke(notificationManager);
            @SuppressLint("PrivateApi") Class<?> iNotificationManagerClazz = Class.forName("android.app.INotificationManager");
            Object proxy = Proxy.newProxyInstance(context.getClass().getClassLoader(), new Class[]{iNotificationManagerClazz}, new NotifictionProxy(sService));
            //获取原来的对象
            Field mServiceField = notificationManager.getClass().getDeclaredField("sService");
            mServiceField.setAccessible(true);
            mServiceField.set(notificationManager, proxy);
            //替换
            Log.e("-->", "Hook NoticeManager成功");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static class NotifictionProxy implements InvocationHandler {


        private Object mObject;

        public NotifictionProxy(Object mObject) {
            this.mObject = mObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Log.e("-->", "方法为:" + method.getName());
            /**
             * 做一些业务上的判断
             * 这里以发送通知为准,发送通知最终的调用了enqueueNotificationWithTag
             */
            if (method.getName().equals("enqueueNotificationWithTag")) {
                //具体的逻辑
                for (int i = 0; i < args.length; i++) {
                    if (args[i] != null) {
                        Log.e("-->", "参数为:" + args[i].toString());
                    }
                }
                //做些其他事情，然后替换参数之类
                return method.invoke(mObject, args);
            }
            return null;
        }
    }
}

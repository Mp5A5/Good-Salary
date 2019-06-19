package com.mp5a5.www.salary;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

/**
 * @author ：mp5a5 on 2019-05-15 13：52
 * @describe
 * @email：wwb199055@126.com
 */
public class IApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        HookNotificationManager.hookNotificationManager(this);
        Intent intent=new Intent();
        Notification notification = new NotificationCompat.Builder(this,"")
                .setContentTitle("测试通知")
                .setContentText("测试通知内容")
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(PendingIntent.getService(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT))
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify((int)(System.currentTimeMillis()/1000L),notification);

    }
}

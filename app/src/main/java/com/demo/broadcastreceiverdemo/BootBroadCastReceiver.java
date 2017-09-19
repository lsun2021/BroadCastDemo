package com.demo.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 静态注册：新建一个类继承BroadcaseReceiver，然后在AndroidMainfest.xml文件中看到<receiver></receiver>
 */
public class BootBroadCastReceiver extends BroadcastReceiver {

    private static final String TAG = "BootBroadCastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: "+"系统启动了,启动了" );
        Toast.makeText(context, "启动Broadcast", Toast.LENGTH_SHORT).show();
    }
}

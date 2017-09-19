package com.demo.broadcastreceiverdemo.myStyle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 自定义广播接收器，然后修改AndroidMainfest.xml对接收器进行修改
 */
public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "快给我发过来啊，广播", Toast.LENGTH_SHORT).show();
        abortBroadcast();//拦截广播
    }
}

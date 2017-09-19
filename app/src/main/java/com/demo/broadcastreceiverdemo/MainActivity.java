package com.demo.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 动态注册：代码注册，在代码中完成注册，具体步骤看MainActivity
 */
public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           myReceiver = new MyReceiver();
        //创建过滤器，并制定action,使之用于接收同action的广播
        IntentFilter  intentFilter=new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        /**
         *  IntentFilter  intentFilter=new IntentFilter();
         *  intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
         */
        //注册广播接收器
        registerReceiver(myReceiver,intentFilter);

    }


    class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "网络连接状态发生改变", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}

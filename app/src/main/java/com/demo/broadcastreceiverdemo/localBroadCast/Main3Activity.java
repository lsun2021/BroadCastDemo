package com.demo.broadcastreceiverdemo.localBroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.broadcastreceiverdemo.R;

public class Main3Activity extends AppCompatActivity {

    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter;
    private LocalBroadCastReceiver localBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //获取实例
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button= (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.demo.broadcastreceiverdemo.MY_LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.demo.broadcastreceiverdemo.MY_LOCAL_BROADCAST");
        localBroadCastReceiver = new LocalBroadCastReceiver();
        localBroadcastManager.registerReceiver(localBroadCastReceiver,intentFilter);//注册本地广播监听器
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      localBroadcastManager.unregisterReceiver(localBroadCastReceiver);
    }

    class LocalBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "接受本地的广播消息", Toast.LENGTH_SHORT).show();
        }
    }
}

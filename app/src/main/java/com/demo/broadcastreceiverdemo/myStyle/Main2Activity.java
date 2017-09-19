package com.demo.broadcastreceiverdemo.myStyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo.broadcastreceiverdemo.R;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent("com.demo.broadcastreceiverdemo.MY_BROADCAST");
//              sendBroadcast(intent);
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}

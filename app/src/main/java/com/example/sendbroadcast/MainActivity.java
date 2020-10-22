package com.example.sendbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.example.EXAMPLE_ACTION".equals(intent.getAction())) {
                String receivedText = intent.getStringExtra("com.example.EXTRA_TEXT");
                textView.setText(receivedText);
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver, filter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    public void sendBroadcasts(View v) {


       /* Intent int ent = new Intent();
        ComponentName cn = new ComponentName( "com.example.broadcast","com.example.broadcast.ExampleBroadcast");
        intent.setComponent(cn);*/
       /*Intent intent = new Intent();
       intent.setClassName("com.example.broadcast","com.example.broadcast.ExampleBroadcast");*/

        Intent intent = new Intent("com.example.EXAMPLE_ACTION");
        intent.putExtra("com.example.EXTRA_TEXT", "10/31/20,20");
        intent.setClassName("com.example.dysguwidget_ver4",
                "com.example.dysguwidget_ver4.WidgetProvider");
        sendBroadcast(intent);
        Intent intent1 = new Intent("com.example.EXAMPLE_ACTION");
        intent1.putExtra("com.example.EXTRA_TEXT", "HAPPY HALLOWEEN!");
        sendBroadcast(intent1);

    }

}


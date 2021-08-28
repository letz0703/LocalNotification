package com.letz.localnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class receivers extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        // text 받기
        String text = intent.getStringExtra("toast");
        // text 표시
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();


    }
}

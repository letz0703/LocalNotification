package com.letz.localnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationManagerCompat;

public class receiverDismiss extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        //show to user
        NotificationManagerCompat compat = NotificationManagerCompat.from(context);
        compat.cancel(1);
    }
}

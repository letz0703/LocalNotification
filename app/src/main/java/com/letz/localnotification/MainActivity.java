package com.letz.localnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button button;
    public final String CHANNEL_ID = "1";
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(
                v -> {
                    counter ++;
                    button.setText("" + counter);
                    if (counter == 5){
                        startNotification();
                    }
                }
        );
    }

    public void startNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "1", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
            //customize it

            Notification.Builder builder = new Notification.Builder(MainActivity.this, CHANNEL_ID);
            builder.setSmallIcon(R.drawable.ic_baseline_add_alert_24).setContentTitle("Title").setContentText("Notification Text")
                    .setPriority(Notification.PRIORITY_DEFAULT);

            //show to user
            NotificationManagerCompat compat = NotificationManagerCompat.from(MainActivity.this);
            compat.notify(1, builder.build());
        }

    }


}


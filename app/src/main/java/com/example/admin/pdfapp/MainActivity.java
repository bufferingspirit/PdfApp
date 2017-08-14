package com.example.admin.pdfapp;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import static com.example.admin.pdfapp.R.id.parent;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTimer(View view){
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }

    public void startNotification(View view){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_warning_black_24dp);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/L_jWHffIx5E"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle("Warning");
        builder.setContentText("You have entered a restricted area");

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(1, builder.build());
    }
    public void cancelNotification(View view){
        notificationManager.cancel(1);
    }

    public void startPDFViewer(View view){
        Intent intent = new Intent(this, PdfActivity.class);
        startActivity(intent);
    }

    public void panicDefault(View view){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog);
        builder.setTitle("PANIC").show();

    }
    public void panicCustom(View view){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog, null);
        builder.setView(dialogView);

        TextView textView = (TextView) dialogView.findViewById(R.id.alertMessage);
        textView.setText("Choose Action");
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.options, R.layout.support_simple_spinner_dropdown_item);
        ListView lv = (ListView) dialogView.findViewById(R.id.alertOptions);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String action = ((TextView) view).getText().toString();

                switch(action) {
                    case "Fix":
                        alertDialog.cancel();
                        Toast.makeText(getApplicationContext(), "Problem Fixed", Toast.LENGTH_SHORT).show();
                        break;
                    case "Break":
                        alertDialog.cancel();
                        Toast.makeText(getApplicationContext(), "You Broke it", Toast.LENGTH_SHORT).show();
                        break;
                    case "Dismiss":
                        alertDialog.cancel();
                        Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    public void startPictureDialog(View view){
        final PictureDialog d = new PictureDialog();
        getSupportFragmentManager().beginTransaction()
                .add(d, "Pic")
                .commit();

        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long l) {
            }

            public void onFinish() {
                getSupportFragmentManager().beginTransaction().remove(d).commit();
            }

        }.start();
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, SMSActivity.class);
        startActivity(intent);
    }

}

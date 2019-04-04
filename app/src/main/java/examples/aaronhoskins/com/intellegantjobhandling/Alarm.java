package examples.aaronhoskins.com.intellegantjobhandling;

import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;

public class Alarm extends BroadcastReceiver {
    public static final int ONE_SECOND = 1000;
    public static final int ONE_MINUTE = ONE_SECOND * 60;
    AlarmManager alarmManager;
    Context context;
    PendingIntent alarmIntent;

    public Alarm(Context context) {
        this.context = context;
        alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
    }

    public void setAlarm() {
        Intent intent = new Intent();
        intent.setAction("alarm");
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() +
                        ONE_SECOND * 10, alarmIntent);
        Log.d("TAG", "setAlarm: ");

    }

    public void downloadUpdates() {
        Log.d("TAG", "downloadUpdates: DOWNLOADING");
        DownloadManager downloadmanager
                = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse("https://images.freeimages.com/images/large-previews/7bc/bald-eagle-1-1400106.jpg");
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("My File");
        request.setDescription("Downloading");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationUri(Uri.parse("file://" + "sdcard/Download/bald-eagle-1-1400106.jpg" ));
        Log.d("TAG", "downloadUpdates: " + Environment.getExternalStorageDirectory().getPath() + "/Download/bald-eagle-1-1400106.jpg");
        downloadmanager.enqueue(request);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TAG", "onReceive: RECIVED");
        downloadUpdates();
        //setAlarm();
    }
}

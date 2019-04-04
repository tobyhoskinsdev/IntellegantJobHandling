package examples.aaronhoskins.com.intellegantjobhandling;

import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobScheduler extends JobService {
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d("TAG", "onStartJob: STARTING JOB");
        for(int i = 0; i < 20 ; i++){
            try {
                Thread.sleep(1000);
                Log.d("TAG", "onStartJob: SERVICE RAN FOR " + i + " Seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        onStopJob(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d("TAG", "onStopJob: STOPPING JOB");
        return false;
    }



}

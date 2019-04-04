package examples.aaronhoskins.com.intellegantjobhandling;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class RefreshWorker extends Worker {
    public RefreshWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("RefreshDataWorker", "refreshing data....");
        return Worker.Result.success();
    }
}

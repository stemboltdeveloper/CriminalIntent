package com.stembo.android.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;

/**
 * Created by myxom on 16/01/25.
 */
public class RefreshScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //screen brightness refresh start
        PowerManager pm =
                (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl =
                pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "WakeAct");
        wl.acquire();
        //wl.release();
        //screen brightness refresh end

        this.finish();
        return;
    }
}

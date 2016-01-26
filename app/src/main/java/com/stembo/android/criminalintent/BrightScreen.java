package com.stembo.android.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;

/**
 * Created by myxom on 16/01/25.
 */
public class BrightScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //screen brightness refresh start
        PowerManager pm =
                (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl =
                pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "WakeAct");

        //Retreive the current charge status from the BatteryManager sticky Intent
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = getApplicationContext().registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPercent = level / (float)scale;

        if (batteryPercent > 50){
            wl.acquire();
        } else {
            if (wl.isHeld()){
                wl.release();
            }
        }
        //screen brightness refresh end

        this.finish();
        return;
    }
}

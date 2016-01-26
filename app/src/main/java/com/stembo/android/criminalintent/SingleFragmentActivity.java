package com.stembo.android.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.WindowManager;

/**
 * Created by myxom on 16/01/15.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    int max_bright = 255;

    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Intent bright_intent = new Intent(SingleFragmentActivity.this, RefreshScreen.class);
        startActivity(bright_intent);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

}

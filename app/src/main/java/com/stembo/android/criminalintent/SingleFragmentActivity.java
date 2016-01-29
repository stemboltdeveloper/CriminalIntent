package com.stembo.android.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by myxom on 16/01/15.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    int max_bright = 255;

    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //launch screen brightness activity end
        Intent bright_intent = new Intent(SingleFragmentActivity.this, BrightScreen.class);
        startActivity(bright_intent);
        //launch screen brightness activity end

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

}

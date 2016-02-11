package com.stembo.android.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by myxom on 16/01/14.
 */
public class Crime {

    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;

    public Crime() {
        // Generator unique identifier
        this(UUID.randomUUID());
        //mID = UUID.randomUUID();
        //mDate = new Date();
    }

    public Crime(UUID id){
        mID = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect){
        mSuspect = suspect;
    }

    public String getPhotoFileName(){
        return "IMG_" + getId().toString() + ".jpg";
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}

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

    public Crime() {
        // Generator unique identifier
        mID = UUID.randomUUID();
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

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
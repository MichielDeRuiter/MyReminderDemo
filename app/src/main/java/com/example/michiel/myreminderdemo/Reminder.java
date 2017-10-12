package com.example.michiel.myreminderdemo;

/**
 * Created by michiel on 12-10-17.
 */

public class Reminder {

    private String mReminderText;

    @Override
    public String toString() {
        return mReminderText;
    }

    public String getmReminderText() {
        return mReminderText;
    }

    public void setmReminderText(String mReminderText) {
        this.mReminderText = mReminderText;
    }

    public Reminder(String mReminderText) {
        this.mReminderText = mReminderText;
    }
}

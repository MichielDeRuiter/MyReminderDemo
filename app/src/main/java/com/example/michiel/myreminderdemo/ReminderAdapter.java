package com.example.michiel.myreminderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by michiel on 12-10-17.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder> {


    private ReminderClickListener mReminderClickListener;
    private List<Reminder> mReminders;

    public ReminderAdapter(ReminderClickListener ReminderClickListener, List<Reminder> reminders) {
        mReminders = reminders;
        mReminderClickListener = ReminderClickListener;
    }


    public interface ReminderClickListener{

        void reminderOnClick (Reminder reminder, int position);
        void reminderOnLongClick (int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        private List<Reminder> mReminders;
        public View  mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            textView= (TextView) itemView.findViewById(android.R.id.text1);
        }
    }






    @Override
    public ReminderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);

// Return a new holder instance
        ReminderAdapter.ViewHolder viewHolder = new ReminderAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReminderAdapter.ViewHolder holder,final int position) {
        final Reminder reminder =  mReminders.get(position);
        holder.textView.setText(reminder.getmReminderText());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mReminderClickListener.reminderOnClick(reminder, position);
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mReminderClickListener.reminderOnLongClick(position);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mReminders.size();
    }




}

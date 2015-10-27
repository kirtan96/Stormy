package com.kirtan.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kirtan.stormy.R;
import com.kirtan.stormy.weather.Day;

/**
 * Created by Kirtan on 8/17/15.
 */
public class DayAdapter extends BaseAdapter {
    private Context mContext;
    private Day[] mDays;
    String s = "";

    public DayAdapter(Context context, Day[] days, String x)
    {
        mContext = context;
        mDays = days;
        s = x;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageview = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];
        holder.iconImageview.setImageResource(day.getIconId());
        int d = day.getmTemperatureMax();
        if(s.equals("C"))
        {
            d = (int)((d-32)/1.8);//
        }
        holder.temperatureLabel.setText(d + "");
        if(position == 0)
        {
            holder.dayLabel.setText("Today");
        }
        else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }
        return convertView;
    }

    public static class ViewHolder{
        ImageView iconImageview;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}

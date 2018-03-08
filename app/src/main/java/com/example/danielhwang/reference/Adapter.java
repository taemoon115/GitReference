package com.example.danielhwang.reference;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel Hwang on 2018-02-26.
 */

public class Adapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<GitReference> mData;

    public Adapter(Context context, ArrayList<GitReference> data)
    {
        mContext = context;
        mData = data;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = mInflater.inflate(R.layout.content_main, parent, false);
        TextView command = rowView.findViewById(R.id.command);
        TextView example = rowView.findViewById(R.id.example);
        TextView explanation = rowView.findViewById(R.id.explanation);

        GitReference gitreference = (GitReference) getItem(position);

        command.setText(gitreference.getCommand());
        example.setText(gitreference.getExample());
        explanation.setText(gitreference.getExplanation());

        return rowView;


    }
}



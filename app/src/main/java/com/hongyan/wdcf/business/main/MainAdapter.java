package com.hongyan.wdcf.business.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongyan.base.PageInfo;
import com.hongyan.wdcf.widget.ItemA;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {

    private ArrayList<PageInfo> mList = new ArrayList<>();
    private Context mContext;

    public MainAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<PageInfo> list) {
        if (list == null) {
            return;
        }
        this.mList.clear();
        this.mList.addAll(list);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PageInfo pageInfo = mList.get(position);
        ItemA itemA = new ItemA(mContext);
        itemA.setTitle(pageInfo.pageDesc);
        itemA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class clz = null;
                try {
                    clz = Class.forName(pageInfo.pageName);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (clz == null) {
                    return;
                }
                Intent intent = new Intent(mContext, clz);
                mContext.startActivity(intent);
            }
        });
        return itemA;
    }

}

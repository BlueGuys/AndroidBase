package com.hongyan.wdcf.business.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongyan.base.PageData;
import com.hongyan.parse.GsonUtils;
import com.hongyan.wdcf.widget.ItemA;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {

    private ArrayList<PageData.PageInfo> mList = new ArrayList<>();
    private Context mContext;

    public MainAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(PageData pageData) {
        if (pageData == null) {
            return;
        }
        this.mList.clear();
        this.mList.addAll(pageData.pageList);
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
        final PageData.PageInfo pageInfo = mList.get(position);
        ItemA itemA = new ItemA(mContext);
        itemA.setTitle(pageInfo.desc);
        itemA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class clz = null;
                try {
                    clz = Class.forName(pageInfo.name);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (clz == null) {
                    return;
                }
                Intent intent = new Intent(mContext, clz);
                intent.putExtra("params", GsonUtils.toJson(pageInfo.params));
                mContext.startActivity(intent);
            }
        });
        return itemA;
    }

}

package com.hongyan.wdcf.business.main;

import android.content.Context;
import android.widget.ListView;

import com.hongyan.base.ActivityView;
import com.hongyan.base.PageData;
import com.hongyan.parse.GsonUtils;
import com.hongyan.wdcf.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainView extends ActivityView {

    private ListView listView;
    private MainAdapter adapter;

    public MainView(Context context) {
        super(context);
        addBusinessView(R.layout.activity_main);
        initView();
        initData();
    }

    protected void initView() {
        if (rootView == null) {
            return;
        }
        listView = findViewById(R.id.listView);
        adapter = new MainAdapter(mContext);
        listView.setAdapter(adapter);
    }

    private void initData() {
        StringBuilder builder = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(mContext.getResources().getAssets().open("pageList"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pageListStr = builder.toString();
        PageData pageData = GsonUtils.gsonResolve(pageListStr, PageData.class);
        adapter.setData(pageData);
        adapter.notifyDataSetChanged();
    }

}

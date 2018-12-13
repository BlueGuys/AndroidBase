package com.hongyan.wdcf.business.main;

import android.content.Context;
import android.widget.ListView;

import com.hongyan.base.ActivityView;
import com.hongyan.base.PageInfo;
import com.hongyan.wdcf.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        ArrayList<PageInfo> pageInfoArrayList = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(pageListStr);
            JSONArray pageList = data.getJSONArray("pageList");
            if (pageList != null && pageList.length() > 0) {
                for (int i = 0; i < pageList.length(); i++) {
                    JSONObject page = pageList.getJSONObject(i);
                    PageInfo pageInfo = new PageInfo();
                    pageInfo.pageId = page.optString("id");
                    pageInfo.pageName = page.optString("name");
                    pageInfo.pageDesc = page.optString("desc");
                    pageInfoArrayList.add(pageInfo);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.setData(pageInfoArrayList);
        adapter.notifyDataSetChanged();
    }

}

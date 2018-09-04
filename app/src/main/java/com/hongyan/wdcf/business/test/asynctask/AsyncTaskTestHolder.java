package com.hongyan.wdcf.business.test.asynctask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseResult;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.base.IViewHolder;
import com.hongyan.base.RequestBean;
import com.hongyan.wdcf.R;

import java.lang.ref.WeakReference;

/**
 * Created by wangning on 2018/6/10.
 */

public class AsyncTaskTestHolder extends BaseViewHolder implements IViewHolder {

    private Button buttonStart;
    private Button buttonCancel;
    ProgressBar progressBar;
    private DownloadAsyncTask mTask;

    public AsyncTaskTestHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_async_test;
    }

    @Override
    public int getLayoutType() {
        return IViewHolder.LAYOUT_TYPE_COMMON;
    }

    @Override
    public boolean needPageRequest() {
        return false;
    }

    @Override
    public void initView(View rootView) {
        buttonStart = rootView.findViewById(R.id.btn_start);
        buttonCancel = rootView.findViewById(R.id.btn_cancel);
        progressBar = rootView.findViewById(R.id.progressBar);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTask = new DownloadAsyncTask(AsyncTaskTestHolder.this);
                mTask.execute();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTask == null) {
                    return;
                }
                mTask.cancel(true);
            }
        });
    }

    /**
     * 三种泛型类型分别代表“启动任务执行的输入参数”、“后台任务执行的进度”、“后台计算结果的类型”。在特定场合下，并不是所有类型都被使用，如果没有被使用，可以用java.lang.Void类型代替。
     */
    private static class DownloadAsyncTask extends AsyncTask<String, Integer, String> {

        WeakReference<AsyncTaskTestHolder> holder;

        DownloadAsyncTask(AsyncTaskTestHolder holder) {
            this.holder = new WeakReference<>(holder);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(180);
                    publishProgress(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return String.valueOf("hello");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            AsyncTaskTestHolder mHolder = holder.get();
            if (mHolder != null) {
                mHolder.progressBar.setProgress(values[0]);
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

    @Override
    protected boolean hideNavigationView() {
        return true;
    }

    @Override
    public int getNavigationTitle() {
        return 0;
    }


    @Override
    public RequestBean getRequestBean() {
        return null;
    }

    @Override
    public <T extends BaseResult> void onRequestSuccess(T result) {

    }

    @Override
    public boolean onRequestFail() {
        return false;
    }

}

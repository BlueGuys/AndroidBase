package com.hongyan.wdcf.business.asynctask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.hongyan.base.BaseActivity;
import com.hongyan.base.BaseViewHolder;
import com.hongyan.wdcf.R;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;

public class AsyncTaskTestHolder extends BaseViewHolder {

    ProgressBar progressBar1;
    private DownloadAsyncTask1 mTask1;

    ProgressBar progressBar2;
    private DownloadAsyncTask2 mTask2;

    public AsyncTaskTestHolder(BaseActivity mActivity) {
        super(mActivity);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_device_info;
    }

    @Override
    public void initView() {
        Button buttonStart1 = rootView.findViewById(R.id.btn_start1);
        Button buttonCancel1 = rootView.findViewById(R.id.btn_cancel1);
        progressBar1 = rootView.findViewById(R.id.progressBar1);
        buttonStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTask1 != null) {
                    mTask1.cancel(true);
                    mTask1 = null;
                }
                getTaskQueueID();
                mTask1 = new DownloadAsyncTask1(AsyncTaskTestHolder.this);
                mTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                mTask1.execute();
            }
        });
        buttonCancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTask1 == null) {
                    return;
                }
                mTask1.cancel(true);
            }
        });

        Button buttonStart2 = rootView.findViewById(R.id.btn_start2);
        Button buttonCancel2 = rootView.findViewById(R.id.btn_cancel2);
        progressBar2 = rootView.findViewById(R.id.progressBar2);
        buttonStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTask2 != null) {
                    mTask2.cancel(true);
                    mTask2 = null;
                }
                getTaskQueueID();
                mTask2 = new DownloadAsyncTask2(AsyncTaskTestHolder.this);
                mTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                mTask2.execute();
            }
        });
        buttonCancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTask2 == null) {
                    return;
                }
                mTask2.cancel(true);
            }
        });
    }

    /**
     * 三种泛型类型分别代表“启动任务执行的输入参数”、“后台任务执行的进度”、“后台计算结果的类型”。在特定场合下，并不是所有类型都被使用，如果没有被使用，可以用java.lang.Void类型代替。
     */
    private static class DownloadAsyncTask1 extends AsyncTask<String, Integer, String> {

        WeakReference<AsyncTaskTestHolder> holder;

        DownloadAsyncTask1(AsyncTaskTestHolder holder) {
            this.holder = new WeakReference<>(holder);
        }

        /**
         * 这个方法是在执行异步任务之前的时候执行，并且是在UI Thread当中执行的，通常我们在这个方法里做一些UI控件的初始化的操作，例如弹出要给ProgressDialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * 在onPreExecute()方法执行完之后，会马上执行这个方法，这个方法就是来处理异步任务的方法，Android操作系统会在后台的线程池当中开启一个worker thread来执行我们的这个方法，所以这个方法是在worker thread当中执行的，这个方法执行完之后就可以将我们的执行结果发送给我们的最后一个 onPostExecute 方法，在这个方法里，我们可以从网络当中获取数据等一些耗时的操作
         *
         * @param strings
         * @return
         */
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

        /**
         * 这个方法也是在UI Thread当中执行的，我们在异步任务执行的时候，有时候需要将执行的进度返回给我们的UI界面，例如下载一张网络图片，我们需要时刻显示其下载的进度，就可以使用这个方法来更新我们的进度。这个方法在调用之前，我们需要在 doInBackground 方法中调用一个 publishProgress(Progress) 的方法来将我们的进度时时刻刻传递给 onProgressUpdate 方法来更新
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            AsyncTaskTestHolder mHolder = holder.get();
            if (mHolder != null) {
                mHolder.progressBar1.setProgress(values[0]);
            }
        }

        /**
         * 当我们的异步任务执行完之后，就会将结果返回给这个方法，这个方法也是在UI Thread当中调用的，我们可以将返回的结果显示在UI控件上
         *
         * @param s
         */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

    /**
     * 三种泛型类型分别代表“启动任务执行的输入参数”、“后台任务执行的进度”、“后台计算结果的类型”。在特定场合下，并不是所有类型都被使用，如果没有被使用，可以用java.lang.Void类型代替。
     */
    private static class DownloadAsyncTask2 extends AsyncTask<String, Integer, String> {

        WeakReference<AsyncTaskTestHolder> holder;

        DownloadAsyncTask2(AsyncTaskTestHolder holder) {
            this.holder = new WeakReference<>(holder);
        }

        /**
         * 这个方法是在执行异步任务之前的时候执行，并且是在UI Thread当中执行的，通常我们在这个方法里做一些UI控件的初始化的操作，例如弹出要给ProgressDialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * 在onPreExecute()方法执行完之后，会马上执行这个方法，这个方法就是来处理异步任务的方法，Android操作系统会在后台的线程池当中开启一个worker thread来执行我们的这个方法，所以这个方法是在worker thread当中执行的，这个方法执行完之后就可以将我们的执行结果发送给我们的最后一个 onPostExecute 方法，在这个方法里，我们可以从网络当中获取数据等一些耗时的操作
         *
         * @param strings
         * @return
         */
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

        /**
         * 这个方法也是在UI Thread当中执行的，我们在异步任务执行的时候，有时候需要将执行的进度返回给我们的UI界面，例如下载一张网络图片，我们需要时刻显示其下载的进度，就可以使用这个方法来更新我们的进度。这个方法在调用之前，我们需要在 doInBackground 方法中调用一个 publishProgress(Progress) 的方法来将我们的进度时时刻刻传递给 onProgressUpdate 方法来更新
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            AsyncTaskTestHolder mHolder = holder.get();
            if (mHolder != null) {
                mHolder.progressBar2.setProgress(values[0]);
            }
        }

        /**
         * 当我们的异步任务执行完之后，就会将结果返回给这个方法，这个方法也是在UI Thread当中调用的，我们可以将返回的结果显示在UI控件上
         *
         * @param s
         */
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

    private String getTaskQueueID() {
        try {
            Class c = Class.forName("android.os.AsyncTask");
            Field field = c.getDeclaredField("SERIAL_EXECUTOR");
            field.setAccessible(true);
            Executor executor = (Executor) field.get(null);
            showErrorToast(executor.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }

}

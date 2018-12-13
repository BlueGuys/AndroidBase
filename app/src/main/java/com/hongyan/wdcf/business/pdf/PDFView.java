package com.hongyan.wdcf.business.pdf;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.hongyan.StringUtils;
import com.hongyan.base.ActivityView;
import com.hongyan.wdcf.R;
import com.hongyan.wdcf.base.DownloadUtil;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import java.io.File;

public class PDFView extends ActivityView implements OnPageChangeListener {

    private com.joanzapata.pdfview.PDFView pdfView;
    private String mUrl;
    private String fileName;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 10001) {
                String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/wdcf/" + fileName;
                File file = new File(url);
                pdfView.fromFile(file)
                        .defaultPage(0)
                        .swipeVertical(true)
                        .load();
            }
        }
    };

    public PDFView(Context context) {
        super(context);
        addBusinessView(R.layout.activity_main);
        initView();
    }

    public void setUrl(String url) {
        this.mUrl = url;
        if (StringUtils.notEmpty(url)) {
            fileName = url.substring(url.lastIndexOf("/", url.length()));
        }
        DownloadUtil.get().download(mUrl, "/wdcf", new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess() {
                Log.e("download", "下载成功");
                handler.sendEmptyMessage(10001);
            }

            @Override
            public void onDownloading(int progress) {

            }

            @Override
            public void onDownloadFailed() {
                Log.e("download", "下载失败");
            }
        });
    }

    protected void initView() {
        pdfView = rootView.findViewById(R.id.pdfview);

    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

}

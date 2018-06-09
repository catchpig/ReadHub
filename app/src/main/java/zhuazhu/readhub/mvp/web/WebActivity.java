package zhuazhu.readhub.mvp.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.OnClick;
import zhuazhu.readhub.R;
import zhuazhu.readhub.log.Logger;
import zhuazhu.readhub.mvp.base.activity.BaseActivity;
import zhuazhu.readhub.mvp.web.client.ReadHubChromeClient;
import zhuazhu.readhub.mvp.web.client.ReadHubChromeClient.onReceivedTitleListener;
import zhuazhu.readhub.mvp.web.client.ReadHubClient;

import static zhuazhu.readhub.mvp.web.client.ReadHubChromeClient.*;

/**
 * @author zhuazhu
 **/
public class WebActivity extends BaseActivity implements onReceivedTitleListener,OnRecievedProgressListener {
    private static final String TAG = "WebActivity";
    private static final String URL_KEY = "url";
    public static void start(Context context,String url){
        Intent intent = new Intent(context,WebActivity.class);
        intent.putExtra(URL_KEY,url);
        context.startActivity(intent);
    }
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.frame_web)
    FrameLayout mFrameWeb;
    @BindView(R.id.progress)
    ProgressBar mProgressBar;
    @BindView(R.id.web_view)
    WebView mWebView;

    private String mUrl;
    @Override
    protected int getlayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
        initView();
    }
    private void initParam(){
        Intent intent = getIntent();
        mUrl = intent.getStringExtra(URL_KEY);
    }
    private void initView(){
        //网页中的视频，上屏幕的时候，可能出现闪烁的情况,需要如下设置：Activity在onCreate时需要设置
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        ReadHubChromeClient readHubChromeClient = new ReadHubChromeClient();
        readHubChromeClient.setOnReceivedTitleListener(this);
        readHubChromeClient.setOnRecievedProgressListener(this);
        mWebView.setWebChromeClient(readHubChromeClient);
        mWebView.setWebViewClient(new ReadHubClient());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl(mUrl);
    }

    @OnClick(R.id.back)
    protected void back(){
        finish();
    }

    @Override
    public void onReceivedTitle(String title) {
        Logger.i(TAG,"标题为->%s",title);
        mTitle.setText(title);
    }

    @Override
    public void onReceivedProgress(int progress) {
        Logger.i(TAG,"加载进度为->%d",progress);
        mProgressBar.setProgress(progress);
        if (progress==100) {
            mProgressBar.setVisibility(View.GONE);
        }else{
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }
}

package zhuazhu.readhub.mvp.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;

import butterknife.BindView;
import butterknife.OnClick;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.activity.BaseActivity;

/**
 * @author zhuazhu
 **/
public class WebActivity extends BaseActivity {
    private static final String TAG = "WebActivity";
    private static final String URL_KEY = "url";
    public static void start(Context context,String url){
        Intent intent = new Intent(context,WebActivity.class);
        intent.putExtra(URL_KEY,url);
        context.startActivity(intent);
    }
    @BindView(R.id.frame_web)
    FrameLayout mFrameWeb;
    @BindView(R.id.title)
    TextView mTitle;

    private AgentWeb mAgentWeb;
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
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mFrameWeb,new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator(ContextCompat.getColor(this,R.color.c_6c8cff))
                .setWebChromeClient(new WebChromeClient(){
                    @Override
                    public void onReceivedTitle(WebView view, String title) {
                        super.onReceivedTitle(view, title);
                        if (title!=null) {
                            mTitle.setText(title);
                        }
                    }
                })
                .createAgentWeb()
                .ready()
                .go(mUrl);
    }
    @OnClick(R.id.back)
    protected void back(){
        finish();
    }
    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }
}

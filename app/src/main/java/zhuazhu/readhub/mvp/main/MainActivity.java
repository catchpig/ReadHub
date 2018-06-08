package zhuazhu.readhub.mvp.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.tencent.bugly.beta.Beta;

import butterknife.BindView;
import butterknife.OnClick;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.activity.BaseActivity;
import zhuazhu.readhub.mvp.hot.view.HotFragment;
import zhuazhu.readhub.mvp.mine.view.MineFragment;
import zhuazhu.readhub.mvp.news.view.NewsFragment;

@Puppet(containerViewId = R.id.fragment)
public class MainActivity extends BaseActivity {
    public static void start(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
    @BindView(R.id.title)
    TextView mTitle;
    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Beta.checkUpgrade(false,false);
        initView();
    }

    private HotFragment mHotFragment;
    private NewsFragment mNewsFragment;
    private MineFragment mMineFragment;

    protected void initView() {
        mHotFragment = HotFragment.newInstance();
        mNewsFragment = NewsFragment.newInstance();
        mMineFragment = MineFragment.newInstance();
        Rigger.getRigger(this).addFragment(R.id.fragment,mHotFragment,mNewsFragment,mMineFragment);
        clickHot();
    }
    @OnClick(R.id.radio_hot)
    protected void clickHot(){
        mTitle.setText("热门");
        Rigger.getRigger(this).showFragment(mHotFragment.getFragmentTag());
    }
    @OnClick(R.id.radio_news)
    protected void clickNews(){
        mTitle.setText("资讯");
        Rigger.getRigger(this).showFragment(mNewsFragment.getFragmentTag());
    }
    @OnClick(R.id.radio_mine)
    protected void clickMine(){
        mTitle.setText("我的");
        Rigger.getRigger(this).showFragment(mMineFragment.getFragmentTag());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AppUtils.exitApp();
        Rigger.getRigger(this).close();
    }
}

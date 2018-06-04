package zhuazhu.readhub.mvp.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.IRigger;
import com.jkb.fragment.rigger.rigger.Rigger;

import butterknife.BindView;
import butterknife.OnClick;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.BaseActivity;
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
    protected void initParam() {

    }
    private HotFragment mHotFragment;
    private NewsFragment mNewsFragment;
    private MineFragment mMineFragment;
    @Override
    protected void initView() {
        mHotFragment = HotFragment.newInstance();
        mNewsFragment = NewsFragment.newInstance();
        mMineFragment = MineFragment.newInstance();
        Rigger.enableDebugLogging(true);
        Rigger.getRigger(this).addFragment(R.id.fragment,mHotFragment,mNewsFragment,mMineFragment);
        clickHot();
    }
    @OnClick(R.id.radio_hot)
    protected void clickHot(){
        mTitle.setText("热门");
        Rigger.getRigger(this).showFragment(mHotFragment,R.id.fragment);
    }
    @OnClick(R.id.radio_news)
    protected void clickNews(){
        mTitle.setText("资讯");
        Rigger.getRigger(this).showFragment(mNewsFragment,R.id.fragment);
    }
    @OnClick(R.id.radio_mine)
    protected void clickMine(){
        mTitle.setText("我的");
        Rigger.getRigger(this).showFragment(mMineFragment,R.id.fragment);
    }
}

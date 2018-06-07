package zhuazhu.readhub.mvp.news.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jkb.fragment.rigger.annotation.Animator;
import com.jkb.fragment.rigger.annotation.LazyLoad;
import com.jkb.fragment.rigger.annotation.Puppet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.fragment.BaseFragment;
import zhuazhu.readhub.mvp.news.adpter.TabViewPagerAdapter;

/**
 * @author zhuazhu
 */
@Puppet
public class NewsFragment extends BaseFragment {
    private static final String TAG = "NewsFragment";
    private static NewsFragment sNewsFragment;
    public static NewsFragment newInstance(){
        if (sNewsFragment==null) {
            sNewsFragment = new NewsFragment();
            sNewsFragment.setArguments(new Bundle());
        }
        return sNewsFragment;
    }

    public String getFragmentTag(){
        return TAG;
    }

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @Override
    protected int getlayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }
    private List<Fragment> mFragments = new ArrayList<>();
    private void initView(){
        mFragments.add(ScienceFragment.newInstance());
        mFragments.add(DeveloperFragment.newInstance());
        mFragments.add(ChainFragment.newIntance());
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(mBaseActivity.getSupportFragmentManager(),mFragments);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("科技动态");
        mTabLayout.getTabAt(1).setText("开发者资讯");
        mTabLayout.getTabAt(2).setText("区块链快讯");
    }
}

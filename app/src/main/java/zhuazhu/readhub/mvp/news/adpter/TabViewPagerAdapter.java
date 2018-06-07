package zhuazhu.readhub.mvp.news.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import zhuazhu.readhub.mvp.news.view.ChainFragment;
import zhuazhu.readhub.mvp.news.view.DeveloperFragment;
import zhuazhu.readhub.mvp.news.view.ScienceFragment;

/**
 * @author zhuazhu
 **/
public class TabViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = new ArrayList<>();

    public TabViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(ScienceFragment.newInstance());
        mFragments.add(DeveloperFragment.newInstance());
        mFragments.add(ChainFragment.newIntance());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}

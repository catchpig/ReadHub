package zhuazhu.readhub.mvp.news.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;

import zhuazhu.readhub.R;

/**
 * @author zhuazhu
 */
@Puppet
public class NewsFragment extends Fragment {
    private static NewsFragment sNewsFragment;
    public static NewsFragment newInstance(){
        if (sNewsFragment==null) {
            sNewsFragment = new NewsFragment();
            sNewsFragment.setArguments(new Bundle());
            Rigger.getRigger(sNewsFragment).setFragmentTag("news");
        }
        return sNewsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news,container,false);
        return v;
    }
}

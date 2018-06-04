package zhuazhu.readhub.mvp.mine.view;

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
public class MineFragment extends Fragment {
    private static MineFragment sMineFragment;
    public static MineFragment newInstance(){
        if (sMineFragment==null) {
            sMineFragment = new MineFragment();
            sMineFragment.setArguments(new Bundle());
            Rigger.getRigger(sMineFragment).setFragmentTag("mine");
        }
        return sMineFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mine,container,false);
        return v;
    }
}

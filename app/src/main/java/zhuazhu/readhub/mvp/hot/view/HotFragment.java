package zhuazhu.readhub.mvp.hot.view;

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
public class HotFragment extends Fragment {
    private static HotFragment sHotFragment;
    public static HotFragment newInstance(){
        if(sHotFragment==null){
            sHotFragment = new HotFragment();
            sHotFragment.setArguments(new Bundle());
            Rigger.getRigger(sHotFragment).setFragmentTag("hot");
        }
        return sHotFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hot,container,false);
        return v;
    }
}

package zhuazhu.readhub.mvp.mine.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.tencent.bugly.beta.Beta;

import butterknife.BindView;
import butterknife.OnClick;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.fragment.BaseFragment;
import zhuazhu.readhub.mvp.web.WebActivity;

/**
 * @author zhuazhu
 */
@Puppet
public class MineFragment extends BaseFragment {
    private static final String TAG = "MineFragment";
    private static MineFragment sMineFragment;
    public static MineFragment newInstance(){
        if (sMineFragment==null) {
            sMineFragment = new MineFragment();
            sMineFragment.setArguments(new Bundle());
        }
        return sMineFragment;
    }
    public String getFragmentTag(){
        return TAG;
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @OnClick({R.id.blog_address,R.id.github_address})
    protected void clickAdress(TextView address){
        WebActivity.start(getBaseActivity(),address.getText().toString());
    }
    @OnClick(R.id.version_update)
    protected void clickVersionUpdate(){
        Beta.checkUpgrade();
    }
}

package zhuazhu.readhub.mvp.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import zhuazhu.readhub.mvp.base.BaseContract;
import zhuazhu.readhub.mvp.base.activity.BaseActivity;

/**
 * @author zhuazhu
 **/
public abstract class BaseFragment extends Fragment implements BaseContract.View {
    private Unbinder mUnbinder;
    protected BaseActivity mBaseActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseActivity = (BaseActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getlayoutId(),container,false);
        mUnbinder = ButterKnife.bind(this,v);
        return v;
    }
    /**
     * 获取布局文件
     * @return
     */
    protected abstract int getlayoutId();

    @Override
    public void showToast(String msg) {
        mBaseActivity.showToast(msg);
    }

    @Override
    public BaseActivity getBaseActivity() {
        return mBaseActivity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=null) {
            mUnbinder.unbind();
        }
    }
}

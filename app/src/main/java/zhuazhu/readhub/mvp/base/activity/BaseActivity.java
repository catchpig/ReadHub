package zhuazhu.readhub.mvp.base.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.jkb.fragment.rigger.annotation.Puppet;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.base.BaseContract;

/**
 * @author zhuazhu
 **/

public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View {
    private Unbinder mUnbinder;
    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        mUnbinder = ButterKnife.bind(this);
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.c_6c8cff).init();
    }

    /**
     * 获取布局文件
     * @return
     */
    protected abstract int getlayoutId();


    @Override
    public void showToast(String msg) {
        ToastUtils.showShort(msg);
    }

    @Override
    public BaseActivity getBaseActivity() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=null) {
            mUnbinder.unbind();
        }
    }
}

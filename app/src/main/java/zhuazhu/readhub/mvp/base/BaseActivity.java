package zhuazhu.readhub.mvp.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;

import javax.inject.Inject;

/**
 * @author zhuazhu
 **/
public abstract class BaseActivity<P extends BaseContract.Presenter> extends AppCompatActivity implements BaseContract.View{
    @Inject
    protected P mPresenter;
    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        initParam();
        initView();
        mPresenter.onCreate();
    }

    /**
     * 获取布局文件
     * @return
     */
    protected abstract int getlayoutId();
    protected abstract void initParam();
    protected abstract void initView();

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @CallSuper
    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @CallSuper
    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showShort(msg);
    }
}

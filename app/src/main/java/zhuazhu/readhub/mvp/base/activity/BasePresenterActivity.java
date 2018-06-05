package zhuazhu.readhub.mvp.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import zhuazhu.readhub.mvp.base.BaseContract;

/**
 * @author zhuazhu
 **/
public abstract class BasePresenterActivity<P extends BaseContract.Presenter> extends BaseActivity {
    @Inject
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
        injectComponent();
        mPresenter.onCreate();
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
    protected abstract void initParam();
    protected abstract void injectComponent();
    protected abstract void initView();
}

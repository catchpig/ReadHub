package zhuazhu.readhub.mvp.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import zhuazhu.readhub.mvp.base.BaseContract;
import zhuazhu.readhub.mvp.base.fragment.BaseFragment;

/**
 * @author zhuazhu
 **/
public abstract class BasePresenterFragment<P extends BaseContract.Presenter> extends BaseFragment {
    @Inject
    protected P mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
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

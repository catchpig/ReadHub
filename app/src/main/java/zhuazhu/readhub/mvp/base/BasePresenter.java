package zhuazhu.readhub.mvp.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author zhuazhu
 **/
public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {
    protected final V mView;
    private final CompositeDisposable mDisposable;

    public BasePresenter(V view) {
        mView = view;
        mDisposable = new CompositeDisposable();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}

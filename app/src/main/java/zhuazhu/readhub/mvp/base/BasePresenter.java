package zhuazhu.readhub.mvp.base;

import android.support.annotation.CallSuper;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import zhuazhu.readhub.data.net.HttpObservable;

/**
 * @author zhuazhu
 **/
public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {
    protected final V mView;
    protected final CompositeDisposable mDisposable;

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
    @CallSuper
    @Override
    public void onDestroy() {
        mDisposable.clear();
    }

    @Override
    public <T> void execute(Observable<T> observable, HttpObservable<T> httpObservable) {
        mDisposable.add(observable.subscribeWith(httpObservable));
    }
}

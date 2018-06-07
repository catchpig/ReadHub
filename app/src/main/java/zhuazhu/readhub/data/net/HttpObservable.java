package zhuazhu.readhub.data.net;

import io.reactivex.observers.ResourceObserver;

/**
 * @author zhuazhu
 **/
public abstract class HttpObservable<T> extends ResourceObserver<T> {
    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}

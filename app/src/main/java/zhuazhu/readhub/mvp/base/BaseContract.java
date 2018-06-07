package zhuazhu.readhub.mvp.base;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import zhuazhu.readhub.mvp.base.activity.BaseActivity;
import zhuazhu.readhub.net.HttpObservable;

/**
 * @author zhuazhu
 **/
public interface BaseContract{
    interface View{
        /**
         * 弹出吐司
         * @param msg
         */
        void showToast(String msg);

        BaseActivity getBaseActivity();
    }
    interface Presenter{
        void onCreate();

        void onResume();

        void onPause();

        void onStop();

        void onDestroy();
        <T> void execute(Observable<T> observable, HttpObservable<T> httpObservable);
    }

}

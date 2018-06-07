package zhuazhu.readhub.utils;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import zhuazhu.readhub.data.net.AjaxResult;

/**
 * @author zhuazhu
 **/
public class RxSchedulersHelper {
    /**
     * 将AjaxResult<T>泛型的T转化出来,并请求数据的时候切换到io现场,返回数据切换到主线程
     * @param observable
     * @param <T>
     * @return
     */
    public static <T> Observable<T> transform(Observable<AjaxResult<T>> observable){
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(tAjaxResult -> tAjaxResult.getData());
    }
}

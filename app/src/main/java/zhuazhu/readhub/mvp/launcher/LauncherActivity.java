package zhuazhu.readhub.mvp.launcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.main.MainActivity;

public class LauncherActivity extends AppCompatActivity {
    private Disposable mDisposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_BAR).init();
        mDisposable = Flowable.interval(3, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                MainActivity.start(LauncherActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable!=null) {
            mDisposable.dispose();
        }
    }
}

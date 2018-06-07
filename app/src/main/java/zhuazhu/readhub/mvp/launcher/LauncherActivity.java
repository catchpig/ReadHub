package zhuazhu.readhub.mvp.launcher;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import zhuazhu.readhub.R;
import zhuazhu.readhub.mvp.main.MainActivity;

public class LauncherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_PHONE_STATE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .delay(3,TimeUnit.SECONDS)
                .subscribe(aBoolean -> {
                    MainActivity.start(LauncherActivity.this);
                    finish();
                });
    }
}

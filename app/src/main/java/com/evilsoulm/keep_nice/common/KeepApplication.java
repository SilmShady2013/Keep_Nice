package com.evilsoulm.keep_nice.common;

import android.app.Application;
import android.content.res.Configuration;
import android.text.TextUtils;

import com.evilsoulm.common.Utils.SysUtils;
import com.evilsoulm.keep_nice.common.app.BaseApplication;
import com.evilsoulm.keep_nice.common.app.KeepMainProcessApplication;
import com.evilsoulm.keep_nice.common.app.KeepSecondProcessApplication;
import com.evilsoulm.keep_nice.dl.components.ApiComponent;
import com.evilsoulm.keep_nice.dl.components.ApplicationComponent;
import com.evilsoulm.keep_nice.dl.components.DaggerApiComponent;
import com.evilsoulm.keep_nice.dl.components.DaggerApplicationComponent;
import com.evilsoulm.keep_nice.dl.modules.ApiModule;
import com.evilsoulm.keep_nice.dl.modules.ApplicationModule;

import java.util.Collections;
import java.util.List;

/**
 * Author by EvilsoulM
 * Data:2015-12-08 17:26
 * Project:Keep_Nice
 * Detail:
 */
public class KeepApplication extends Application {
    private static final List<String> PROCESS_NAME_UI = Collections.singletonList("com.evilsoulm.keep_nice");
    private static KeepApplication application;
    private BaseApplication mBaseApplication;
    private ApplicationComponent applicationComponent;
    private ApiComponent apiComponent;

    public static KeepApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initializeInjector();
        initializeInjectorApi();
        initApplication();
    }

    private void initApplication() {
        String processName = SysUtils.getCurrentProcessName(this);
        if (TextUtils.isEmpty(processName) || PROCESS_NAME_UI.contains(processName)) {
            mBaseApplication = new KeepMainProcessApplication(this);
        } else {
            mBaseApplication = new KeepSecondProcessApplication(this);
        }
        mBaseApplication.onCreate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (mBaseApplication != null) {
            mBaseApplication.onTrimMemory(level);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mBaseApplication != null) {
            mBaseApplication.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mBaseApplication != null) {
            mBaseApplication.onTerminate();
        }
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initializeInjectorApi() {
        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }

}

package hcww.com.orchtech.hcww.mvpebrd;

import android.app.Application;

import hcww.com.orchtech.hcww.mvpebrd.di.component.ApplicationComponent;
import hcww.com.orchtech.hcww.mvpebrd.di.component.DaggerApplicationComponent;
import hcww.com.orchtech.hcww.mvpebrd.di.module.ApplicationModule;
import hcww.com.orchtech.hcww.mvpebrd.di.module.NetModule;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppConstants;
import hcww.com.orchtech.hcww.mvpebrd.utils.AppLogger;

public class MvpApp extends Application {

    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule(AppConstants.BASE_URLS)).build();
        mApplicationComponent.inject(this);

        AppLogger.init();


    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent){
        mApplicationComponent = applicationComponent;
    }
}

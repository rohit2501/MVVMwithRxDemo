package com.example.rohitmishra.mvvmwithretrofit.common;

import android.app.Application;
import android.content.Context;
import com.example.rohitmishra.mvvmwithretrofit.di.component.AppComponent;
import com.example.rohitmishra.mvvmwithretrofit.di.component.DaggerAppComponent;
import com.example.rohitmishra.mvvmwithretrofit.di.module.ApplicationModule;
import com.example.rohitmishra.mvvmwithretrofit.di.module.NetworkModule;
import javax.inject.Singleton;

public class MVVMApplication extends Application {
  private AppComponent appComponent;
  private static Context applicationContext;

  @Override
  public void onCreate() {
    super.onCreate();
    applicationContext = this;
    appComponent =
        DaggerAppComponent.builder()
            .applicationModule(new ApplicationModule(this.getApplicationContext()))
            .networkModule(new NetworkModule())
            .build();
    appComponent.inject(this);
    
  }

  public static MVVMApplication get(Context context) {
    return (MVVMApplication) context.getApplicationContext();
  }

  @Singleton
  public static Context getInstance() {
    return applicationContext;
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}

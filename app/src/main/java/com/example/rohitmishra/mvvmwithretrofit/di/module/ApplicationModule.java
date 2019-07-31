package com.example.rohitmishra.mvvmwithretrofit.di.module;

import android.content.Context;
import com.example.rohitmishra.mvvmwithretrofit.di.annotations.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
  private Context context;

  public ApplicationModule(Context context) {
    this.context = context;
  }

  @ApplicationScope
  @Provides
  Context providesApplicationContext() {
    return context;
  }
}

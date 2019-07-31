package com.example.rohitmishra.mvvmwithretrofit.di.component;

import com.example.rohitmishra.mvvmwithretrofit.common.MVVMApplication;
import com.example.rohitmishra.mvvmwithretrofit.country.di.CountryComponent;
import com.example.rohitmishra.mvvmwithretrofit.country.di.CountryViewModelModule;
import com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel.CountryViewModel;
import com.example.rohitmishra.mvvmwithretrofit.di.annotations.ApplicationScope;
import com.example.rohitmishra.mvvmwithretrofit.di.module.ApiModule;
import com.example.rohitmishra.mvvmwithretrofit.di.module.ApplicationModule;
import com.example.rohitmishra.mvvmwithretrofit.di.module.NetworkModule;
import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, NetworkModule.class, ApiModule.class})
public interface AppComponent {
  void inject(MVVMApplication application);

  CountryComponent plus(CountryViewModelModule countryViewModelModule);
  
}

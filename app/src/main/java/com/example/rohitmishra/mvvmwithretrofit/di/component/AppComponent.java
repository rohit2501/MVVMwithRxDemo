package com.example.rohitmishra.mvvmwithretrofit.di.component;

import com.example.rohitmishra.mvvmwithretrofit.common.MVVMApplication;
import com.example.rohitmishra.mvvmwithretrofit.country.di.CountryComponent;
import com.example.rohitmishra.mvvmwithretrofit.country.di.CountryViewModelModule;
import com.example.rohitmishra.mvvmwithretrofit.di.annotations.ApplicationScope;
import com.example.rohitmishra.mvvmwithretrofit.di.module.ApiModule;
import com.example.rohitmishra.mvvmwithretrofit.di.module.ApplicationModule;
import com.example.rohitmishra.mvvmwithretrofit.di.module.NetworkModule;

import dagger.Component;

/**
 * Represents the Application level Dagger component. Method exposed over here can be used across
 * application.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class, NetworkModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MVVMApplication application);

    CountryComponent plus(CountryViewModelModule countryViewModelModule);

}

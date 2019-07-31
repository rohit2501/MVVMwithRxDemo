package com.example.rohitmishra.mvvmwithretrofit.country.di;

import com.example.rohitmishra.mvvmwithretrofit.country.presentation.view.CountrySelectionActivity;
import com.example.rohitmishra.mvvmwithretrofit.di.annotations.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {CountryModelModule.class, CountryViewModelModule.class})
public interface CountryComponent {
    void inject(CountrySelectionActivity activity);
}

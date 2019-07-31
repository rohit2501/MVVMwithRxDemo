package com.example.rohitmishra.mvvmwithretrofit.country.di;

import com.example.rohitmishra.mvvmwithretrofit.country.model.service.CountryServiceContract;
import com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel.CountryViewModel;
import com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel.CountryViewModelContract;
import com.example.rohitmishra.mvvmwithretrofit.di.annotations.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class CountryViewModelModule {

  public CountryViewModelModule() {
    // blank constructor
  }

  @ActivityScope
  @Provides
  CountryViewModelContract providesCountryViewModelContract(CountryServiceContract countryService) {
    return new CountryViewModel(countryService);
  }
}

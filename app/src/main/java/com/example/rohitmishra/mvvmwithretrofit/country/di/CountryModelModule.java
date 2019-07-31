package com.example.rohitmishra.mvvmwithretrofit.country.di;

import com.example.rohitmishra.mvvmwithretrofit.country.model.service.CountryApi;
import com.example.rohitmishra.mvvmwithretrofit.country.model.service.CountryService;
import com.example.rohitmishra.mvvmwithretrofit.country.model.service.CountryServiceContract;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class CountryModelModule {

  public CountryModelModule() {
    // blank constructor
  }

  @Provides
  CountryServiceContract providesCountryService(CountryApi countryApi) {
    return new CountryService(countryApi);
  }

  @Provides
  CountryApi providesCountryApi(Retrofit retrofit) {
    return retrofit.create(CountryApi.class);
  }
}

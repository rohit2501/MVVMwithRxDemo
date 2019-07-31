package com.example.rohitmishra.mvvmwithretrofit.country.model.service;

import io.reactivex.Single;
import java.util.List;

public class CountryService implements CountryServiceContract {
  private final CountryApi countryApi;

  public CountryService(CountryApi countryApi) {
    this.countryApi = countryApi;
  }

  @Override
  public Single<List<CountryResponse>> getCountries(String regionName) {
    return countryApi.getCountries(regionName);
  }
}

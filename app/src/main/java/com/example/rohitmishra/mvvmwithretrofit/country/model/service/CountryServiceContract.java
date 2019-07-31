package com.example.rohitmishra.mvvmwithretrofit.country.model.service;

import io.reactivex.Single;
import java.util.List;

public interface CountryServiceContract {

  /**
   * Used to get {@link List<CountryResponse>} from {@link CountryApi}
   *
   * @param regionName
   * @return
   */
  Single<List<CountryResponse>> getCountries(String regionName);
}

package com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel;

import io.reactivex.Single;
import java.util.List;

public interface CountryViewModelContract {

  /**
   * @param regionName
   * @return A @{@link List} of countries.
   */
  Single<List<CountryItem>> getCountries(String regionName);
}

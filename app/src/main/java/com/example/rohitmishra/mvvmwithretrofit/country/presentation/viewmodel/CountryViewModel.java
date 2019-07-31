package com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel;

import com.example.rohitmishra.mvvmwithretrofit.country.model.service.CountryResponse;
import com.example.rohitmishra.mvvmwithretrofit.country.model.service.CountryServiceContract;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;

public class CountryViewModel implements CountryViewModelContract {
  private final CountryServiceContract countryService;

  public CountryViewModel(CountryServiceContract countryService) {
    this.countryService = countryService;
  }

  @Override
  public Single<List<CountryItem>> getCountries(String regionName) {
    return countryService
        .getCountries(regionName)
        .map(
            new Function<List<CountryResponse>, List<CountryItem>>() {
              @Override
              public List<CountryItem> apply(List<CountryResponse> countryResponses)
                  throws Exception {
                List<CountryItem> countryItems = new ArrayList<>();
                for (CountryResponse countryResponse : countryResponses) {
                  countryItems.add(new CountryItem(countryResponse.getName()));
                }
                return countryItems;
              }
            });
  }
}

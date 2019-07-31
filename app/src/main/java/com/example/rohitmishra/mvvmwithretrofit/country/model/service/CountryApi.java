package com.example.rohitmishra.mvvmwithretrofit.country.model.service;

import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryApi {

  @GET("rest/v2/region/{regionName}")
  Single<List<CountryResponse>> getCountries(@Path("regionName") String regionName);
}

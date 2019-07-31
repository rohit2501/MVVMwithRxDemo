package com.example.rohitmishra.mvvmwithretrofit.di.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
  @Provides
  Retrofit provideRetrofit(
      OkHttpClient client,
      GsonConverterFactory factory,
      RxJava2CallAdapterFactory callAdapterFactory) {
    return new Retrofit.Builder()
        .baseUrl("https://restcountries.eu/")
        .client(client)
        .addConverterFactory(factory)
        .addCallAdapterFactory(callAdapterFactory)
        .build();
  }
}

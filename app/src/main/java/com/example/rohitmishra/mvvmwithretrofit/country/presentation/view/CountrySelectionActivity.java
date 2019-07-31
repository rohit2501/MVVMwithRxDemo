package com.example.rohitmishra.mvvmwithretrofit.country.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.rohitmishra.mvvmwithretrofit.R;
import com.example.rohitmishra.mvvmwithretrofit.common.MVVMApplication;
import com.example.rohitmishra.mvvmwithretrofit.country.di.CountryViewModelModule;
import com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel.CountryItem;
import com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel.CountryViewModelContract;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

import javax.inject.Inject;

public class CountrySelectionActivity extends AppCompatActivity {
    @Inject
    CountryViewModelContract countryViewModelContract;

    @BindView(R.id.country_rv)
    RecyclerView countryRecyclerView;

    private CountryViewAdapter countryViewAdapter;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_selection);
        MVVMApplication.get(this).getAppComponent().plus(new CountryViewModelModule()).inject(this);
        ButterKnife.bind(this);
        subscribeCountryViewModel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    private void subscribeCountryViewModel() {
        countryViewModelContract
                .getCountries("asia")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new SingleObserver<List<CountryItem>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                compositeDisposable.add(d);
                            }

                            @Override
                            public void onSuccess(List<CountryItem> countryItems) {
                                countryViewAdapter = new CountryViewAdapter(countryItems);
                                countryRecyclerView.setHasFixedSize(true);
                                countryRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                countryRecyclerView.addItemDecoration(
                                        new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                                countryRecyclerView.setAdapter(countryViewAdapter);
                                Log.d("Size of list is ", "" + countryItems.size());
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("Error is ", "" + e.getMessage());
                            }
                        });
    }

}

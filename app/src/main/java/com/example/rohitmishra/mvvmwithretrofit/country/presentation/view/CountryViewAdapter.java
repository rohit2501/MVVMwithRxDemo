package com.example.rohitmishra.mvvmwithretrofit.country.presentation.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohitmishra.mvvmwithretrofit.R;
import com.example.rohitmishra.mvvmwithretrofit.country.presentation.viewmodel.CountryItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryViewAdapter extends RecyclerView.Adapter<CountryViewAdapter.CountryViewHolder> {
    private List<CountryItem> countryItems;

    public CountryViewAdapter(List<CountryItem> countryItems) {
        this.countryItems = countryItems;
    }

    @NonNull
    @Override

    public CountryViewAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.counrty_list_item, viewGroup, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewAdapter.CountryViewHolder countryViewHolder, int i) {
        countryViewHolder.countryTextView.setText(countryItems.get(i).getCountryName());

    }

    @Override
    public int getItemCount() {
        return countryItems == null ? 0 : countryItems.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.country_tv)
        TextView countryTextView;

        public CountryViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

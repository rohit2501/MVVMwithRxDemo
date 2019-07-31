package com.example.rohitmishra.mvvmwithretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.rohitmishra.mvvmwithretrofit.country.presentation.view.CountrySelectionActivity;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.countries_button)
  Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.countries_button)
  void onCountryClick() {
    launchCountryActivity();
  }

  private void launchCountryActivity() {
    startActivity(new Intent(this, CountrySelectionActivity.class));
  }
}

package com.covid.datafetch;

import com.covid.datafetch.model.CountryData;
import com.covid.datafetch.model.GlobalData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * DataProviderService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class DataProviderService {
    public void getData(final String country) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://coronavirus-19-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final CovidAPI api = retrofit.create(CovidAPI.class);
        api.getGlobalData()
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(final Call<GlobalData> call,
                                           final Response<GlobalData> response) {
                        System.out.println(response.body());
                    }

                    @Override
                    public void onFailure(final Call<GlobalData> call, final Throwable t) {

                    }
                });
        api.getGlobalData(country)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(final Call<CountryData> call,
                                           final Response<CountryData> response) {
                        System.out.println(response.body());
                    }

                    @Override
                    public void onFailure(final Call<CountryData> call, final Throwable t) {

                    }
                });
    }
}

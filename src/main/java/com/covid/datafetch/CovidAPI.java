package com.covid.datafetch;

import com.covid.datafetch.model.CountryData;
import com.covid.datafetch.model.GlobalData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * CovidAPI.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public interface CovidAPI {
    @GET("http://coronavirus-19-api.herokuapp.com/all")
    Call<GlobalData> getGlobalData();

    @GET("http://coronavirus-19-api.herokuapp.com/countries/{countryName}")
    Call<CountryData> getCountryData(@Path(value = "countryName") final String countryName);
}

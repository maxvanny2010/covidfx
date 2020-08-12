package com.covid.datafetch.model;

import java.util.StringJoiner;

/**
 * DataModel.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class DataModel {
    private GlobalData globalData;
    private CountryData countryData;

    public void setGlobalData(final GlobalData globalData) {
        this.globalData = globalData;
    }

    public void setCountryData(final CountryData countryData) {
        this.countryData = countryData;
    }

    public DataModel(final GlobalData globalData, final CountryData countryData) {
        this.globalData = globalData;
        this.countryData = countryData;
    }

    public GlobalData getGlobalData() {
        return globalData;
    }

    public CountryData getCountryData() {
        return countryData;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DataModel.class.getSimpleName() + "[", "]")
                .add("globalData=" + this.globalData)
                .add("countryData=" + this.countryData)
                .toString();
    }
}

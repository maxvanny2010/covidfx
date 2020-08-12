package com.covid.config;

/**
 * ConfigModel.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class ConfigModel {
    private int refreshIntervalInSeconds;
    private String countryName;
    private String countryCode;

    public ConfigModel() {
        this.refreshIntervalInSeconds = 300;
        this.countryName = "Germany";
        this.countryCode = "GE";
    }

    public int getRefreshIntervalInSeconds() {
        return refreshIntervalInSeconds;
    }

    public void setRefreshIntervalInSeconds(final int refreshIntervalInSeconds) {
        this.refreshIntervalInSeconds = refreshIntervalInSeconds;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }
}

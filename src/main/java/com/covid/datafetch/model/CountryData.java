package com.covid.datafetch.model;

import java.util.StringJoiner;

/**
 * CountryData.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class CountryData {
    public String country;
    private long cases;
    private long todayCases;
    private long deaths;
    private long todayDeaths;
    private long recovered;
    private long active;
    private long critical;
    private long casesPerOneMillion;
    private long deathsPerOneMillion;
    private long totalTests;
    private long testsPerOneMillion;

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(final long cases) {
        this.cases = cases;
    }

    public long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(final long todayCases) {
        this.todayCases = todayCases;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(final long deaths) {
        this.deaths = deaths;
    }

    public long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(final long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(final long recovered) {
        this.recovered = recovered;
    }

    public long getActive() {
        return active;
    }

    public void setActive(final long active) {
        this.active = active;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(final long critical) {
        this.critical = critical;
    }

    public long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(final long casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(final long deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(final long totalTests) {
        this.totalTests = totalTests;
    }

    public long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(final long testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CountryData.class.getSimpleName() + "[", "]")
                .add("country='" + this.country + "'")
                .add("cases=" + this.cases)
                .add("todayCases=" + this.todayCases)
                .add("deaths=" + this.deaths)
                .add("todayDeaths=" + this.todayDeaths)
                .add("recovered=" + this.recovered)
                .add("active=" + this.active)
                .add("critical=" + this.critical)
                .add("casesPerOneMillion=" + this.casesPerOneMillion)
                .add("deathsPerOneMillion=" + this.deathsPerOneMillion)
                .add("totalTests=" + this.totalTests)
                .add("testsPerOneMillion=" + this.testsPerOneMillion)
                .toString();
    }
}

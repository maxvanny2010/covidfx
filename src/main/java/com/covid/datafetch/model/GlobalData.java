package com.covid.datafetch.model;

import java.util.StringJoiner;

/**
 * GlobalData.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 8/12/2020
 */
public class GlobalData {
    private long cases;
    private long deaths;
    private long recovered;

    public long getCases() {
        return cases;
    }

    public void setCases(final long cases) {
        this.cases = cases;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(final long deaths) {
        this.deaths = deaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(final long recovered) {
        this.recovered = recovered;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GlobalData.class.getSimpleName() + "[", "]")
                .add("cases=" + this.cases)
                .add("deaths=" + this.deaths)
                .add("recovered=" + this.recovered)
                .toString();
    }
}

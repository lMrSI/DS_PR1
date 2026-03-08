package edu.uoc.ds.adt;

import java.time.LocalDateTime;

public class WeatherStationData {
    private LocalDateTime dateTime;
    private double temperature;
    private double precipitation;

    public WeatherStationData(LocalDateTime dateTime, double temperature, double precipitation) {
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.precipitation = precipitation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }
}
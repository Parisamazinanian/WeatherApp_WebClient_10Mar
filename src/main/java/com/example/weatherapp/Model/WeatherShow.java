package com.example.weatherapp.Model;

//in this class we are choosing the data which we want to show in the view page
//becase if we have a Grid of Weather type we will get a huge amount of data
public class WeatherShow {
    private String cityName;
    private Double temperature;
    private Double feelsLikeTemperature;
    private Integer humidity;


    public WeatherShow() {
    }

    public WeatherShow(String cityName, Double temperature, Double feelsLikeTemperature, Integer humidity) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.humidity = humidity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        cityName = cityName;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(Double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherShow{" +
                "CityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", feelsLikeTemperature=" + feelsLikeTemperature +
                ", humidity=" + humidity +
                '}';
    }
}

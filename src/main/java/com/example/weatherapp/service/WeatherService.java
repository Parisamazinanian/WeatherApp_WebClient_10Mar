package com.example.weatherapp.service;

import com.example.weatherapp.Model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {
    //connecting to a web API, Webclient is used here
    private final WebClient webClient;
    //we need the builder because we need to build the URL
    public WeatherService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://api.weatherapi.com/v1").build();
    }

    //Get request of a data type of weather
    //city is a value that should be provided by user in the view class

    public Weather getWeather(String city){
        return webClient.get()
                //because we are planning to have query params we need to use uriBuilder as lambda method
                .uri(uriBuilder -> uriBuilder
                        .path("/current.json")
                        .queryParam("key","135fbcdd8ab544cdadf140200220303")
                        //.queryParam("aqi","yes")
                        .queryParam("q",city).build())
                .retrieve()
                .bodyToMono(Weather.class)
                .block();
    }
}

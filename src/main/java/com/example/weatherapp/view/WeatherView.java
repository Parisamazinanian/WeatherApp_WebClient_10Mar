package com.example.weatherapp.view;

import com.example.weatherapp.Model.Weather;
import com.example.weatherapp.Model.WeatherShow;
import com.example.weatherapp.service.WeatherService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.Key;

import java.awt.*;

//Vaadin is used to show the result so we use VerticalLayout interface
//it's default for vaadin Route
@Route("/")
public class WeatherView extends VerticalLayout{
    //with vaadin a constructor of the class is needed with all the vaadin components
    public WeatherView(WeatherService service){
        var grid = new Grid<WeatherShow>(WeatherShow.class);
        TextField city=new TextField();
        city.setPlaceholder("Enter City Name");
        //create the button
        Button checkWeather=new Button("Check Weather");
        //after clicking on the button
        checkWeather.addClickListener(
                click ->{
                    //this block will be executed once the button clicked
                    String cityName= city.getValue();
                    Double temperature=service.getWeather(cityName).getCurrent().getTempC();
                    Double feelsLike=service.getWeather(cityName).getCurrent().getFeelslikeC();
                    Integer humidity=service.getWeather(cityName).getCurrent().getHumidity();
                    WeatherShow weather= new WeatherShow(cityName, temperature,feelsLike, humidity);
                    grid.setItems(weather);
                    //grid.setColumns("City", "Temperature", "FeelsLike", "Humidity");
                }
        );
        checkWeather.addClickShortcut(Key.ENTER);
        add(
                new H1("Weatehr App"),
                grid,
                new HorizontalLayout(
                        city,
                        checkWeather
                )
        );



    }


}

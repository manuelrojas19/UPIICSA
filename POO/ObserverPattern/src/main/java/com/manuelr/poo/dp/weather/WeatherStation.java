package com.manuelr.poo.dp.weather;

import com.manuelr.poo.dp.weather.observer.CurrentConditionsDisplay;
import com.manuelr.poo.dp.weather.observer.ForecastDisplay;
import com.manuelr.poo.dp.weather.observer.StatisticsDisplay;
//
//import com.manuelr.poo.dp.weather.observer.CurrentConditionsDisplay;
//import com.manuelr.poo.dp.weather.observer.ForecastDisplay;
//import com.manuelr.poo.dp.weather.observer.StatisticsDisplay;
import com.manuelr.poo.dp.weather.subject.WeatherData;

/**
 * Hello world!
 *
 */
public class WeatherStation {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
//        
//        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
//        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//        
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		
		System.out.println("----------------------------------");
		weatherData.setMeasurements(80, 65, 30.4f);
		System.out.println("----------------------------------");
		weatherData.setMeasurements(82, 70, 29.2f);
		System.out.println("----------------------------------");
		weatherData.setMeasurements(78, 90, 29.2f);
		System.out.println("----------------------------------");
	}
}

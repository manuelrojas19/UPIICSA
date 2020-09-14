package com.manuelr.poo.dp.weather.observer;

import java.util.Observable;
import java.util.Observer;

import com.manuelr.poo.dp.weather.subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement {
	Observable observable;
	private float currentPressure = 29.92f;
	private float lastPressure;

	public ForecastDisplay(Observable observable) {
		// TODO Auto-generated constructor stub
//		this.setWeatherData(weatherData);
//		weatherData.registerObserver(this);
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.print("Pronóstico: ");
		if (currentPressure > lastPressure) {
			System.out.println("El clima esta mejorando");
		} else if (currentPressure == lastPressure) {
			System.out.println("Mas de lo mismo");
		} else if (currentPressure < lastPressure) {
			System.out.println("El clima esta empeorando");
		}

	}

//	@Override
//	public void update(float temperature, float humidity, float pressure) {
//		lastPressure = currentPressure;
//		currentPressure = pressure;
//		display();
//		
//	}

//	public Subject getWeatherData() {
//		return weatherData;
//	}
//
//	public void setWeatherData(Subject weatherData) {
//		this.weatherData = weatherData;
//	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.lastPressure = currentPressure;
			this.currentPressure = weatherData.getPressure();
			display();
		}
	}

}

package com.manuelr.poo.dp.weather.observer;

import java.util.Observable;
import java.util.Observer;

import com.manuelr.poo.dp.weather.subject.WeatherData;

//import com.manuelr.poo.dp.weather.observer.Observer;
//import com.manuelr.poo.dp.weather.subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out
				.println("Condiciones actuales: " + temperature + " grados centigrados y " + humidity + "% de humedad");
	}
}

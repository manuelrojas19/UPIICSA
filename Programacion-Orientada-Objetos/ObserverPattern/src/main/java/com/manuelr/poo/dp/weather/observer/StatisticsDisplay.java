package com.manuelr.poo.dp.weather.observer;

import java.util.Observable;
import java.util.Observer;

import com.manuelr.poo.dp.weather.subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200f;
	private float tempSum = 0.0f;
	private int numReadings;
//	private Subject weatherData;
	Observable observable;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperatura: " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);

	}

//	@Override
//	public void update(float temperature, float humidity, float pressure) {
//		tempSum += temperature;
//		numReadings++;
//		if (temperature > maxTemp) {
//			maxTemp = temperature;
//		}
//
//		if (temperature < minTemp) {
//			minTemp = temperature;
//		}
//		display();
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
			float tempRead = weatherData.getTemperature();
			this.tempSum += tempRead;
			this.numReadings++;
			if (tempRead > this.maxTemp) {
				this.maxTemp = tempRead;
			}
			if (tempRead < this.minTemp) {
				this.minTemp = tempRead;
			}
			display();
		}

	}

}

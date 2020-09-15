package com.manuelr.poo.dp.weather.subject;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Observable;

//import com.manuelr.poo.dp.weather.observer.Observer;

public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
//		observers = new ArrayList<>();
	}

//	@Override
//	public void registerObserver(Observer o) {
//		observers.add(o);
//	}
//
//	@Override
//	public void removeObserver(Observer o) {
//		int i = observers.indexOf(o);
//		if (i >= 0) {
//			observers.remove(i);
//		}
//
//	}
//
//	@Override
//	public void notifyObservers() {
//		for (int i = 0; i < observers.size(); i++) {
//			Observer observer = (Observer) observers.get(i);
//			observer.update(temperature, humidity, pressure);
//		}

//		Iterator<Observer> observersIterator = observers.iterator();
//		while (observersIterator.hasNext()) {
//			Observer observer = observersIterator.next();
//			observer.update(temperature, humidity, pressure);
//		}

//		observers.forEach(observer -> {
//			observer.update(temperature, humidity, pressure);
//		});
//	}
	
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}
	
	

}

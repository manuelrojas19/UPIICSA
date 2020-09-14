package com.manuelr.poo.dp.weather.subject;

import com.manuelr.poo.dp.weather.observer.Observer;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

package com.manuelr.poo.dp.cafetery;

public abstract class Beverage {
	String description = "Bebida desconociad";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();

}

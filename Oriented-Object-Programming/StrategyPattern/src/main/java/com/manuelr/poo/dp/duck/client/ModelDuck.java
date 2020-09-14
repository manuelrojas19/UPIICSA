package com.manuelr.poo.dp.duck.client;

import com.manuelr.poo.dp.duck.behavior.fly.FlyNotWay;
import com.manuelr.poo.dp.duck.behavior.quack.Quack;

public class ModelDuck extends Duck {
	
	public ModelDuck() {
		flyBehavior = new FlyNotWay();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("Soy un Model Duck");

	}

}

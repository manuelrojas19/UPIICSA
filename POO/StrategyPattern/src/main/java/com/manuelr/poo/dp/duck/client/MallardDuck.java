package com.manuelr.poo.dp.duck.client;

import com.manuelr.poo.dp.duck.behavior.fly.FlyWithWings;
import com.manuelr.poo.dp.duck.behavior.quack.Quack;

public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("Soy un Real Mallard Duck");
	}
}

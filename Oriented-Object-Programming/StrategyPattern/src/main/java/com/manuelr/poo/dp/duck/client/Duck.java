package com.manuelr.poo.dp.duck.client;

import com.manuelr.poo.dp.duck.behavior.fly.FlyBehavior;
import com.manuelr.poo.dp.duck.behavior.quack.QuackBehavior;

public abstract class Duck {
	FlyBehavior flyBehavior; // Cada clase tiene una referencia a algo que implementa la interfaz de
								// comportamiento
	QuackBehavior quackBehavior;
	
	public Duck() {
	
	}

	public void swim() {
		System.out.println("Todos los patos vuelan");
	}

	public abstract void display();

	// En lugar de manejar el comportamiento por si solo, el objeto Duck delega este
	// comportamiento al objeto referenciado por quackBehavior
	public void performQuack() {
		quackBehavior.quack();
	}

	public void performFly() {
		flyBehavior.fly();
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	
}

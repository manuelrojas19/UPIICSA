package com.manuelr.poo.dp.duck.behavior.quack;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<< Silencio >>");

	}

}

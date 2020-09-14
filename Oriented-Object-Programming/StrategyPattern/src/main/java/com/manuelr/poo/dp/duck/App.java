package com.manuelr.poo.dp.duck;

import com.manuelr.poo.dp.duck.behavior.fly.FlyByRocket;
import com.manuelr.poo.dp.duck.client.Duck;
import com.manuelr.poo.dp.duck.client.MallardDuck;
import com.manuelr.poo.dp.duck.client.ModelDuck;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("<-------------------------->");
        
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();	
        mallard.performFly();
 
        System.out.println("<-------------------------->");
        
        Duck model = new ModelDuck();
        model.display();
        model.performQuack();
        model.performFly();
        model.setFlyBehavior(new FlyByRocket());
        System.out.println("Se invoco el setter de mi comportamiento");
        model.performFly();
        
        System.out.println("<-------------------------->");
    }
}

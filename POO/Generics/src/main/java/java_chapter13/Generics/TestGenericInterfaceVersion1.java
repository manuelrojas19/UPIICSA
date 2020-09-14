package java_chapter13.Generics;

import java.util.function.Function;

public class TestGenericInterfaceVersion1 {
	public static void main(String[] args) {
		Function<Integer, String> t = new Function <Integer, String>() {
			@Override
			public String apply(Integer t) {
				
				return "Ingresaste " +	t;
			}
			
		};
		System.out.println(t.apply(10));
	}
}

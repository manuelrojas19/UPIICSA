package java_chapter13.Generics;

import java.util.function.Function;

public class TestGenericInterfaceVersion2 {
	public static void main(String[] args) {
		Function<Integer, String> str = t -> "Ingresaste " + t;
		
		System.out.println(str.apply(10));
	}
}

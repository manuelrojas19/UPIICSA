package java_chapter13.Generics;

public class TestGenericClass {
	public static void main(String[] args) {
		SimpleGenericClass<Double> ejemplo1 = new SimpleGenericClass<>();
		SimpleGenericClass<String> ejemplo2 = new SimpleGenericClass<>();
		SimpleGenericClass<Oblong> ejemplo3 = new SimpleGenericClass<>();
		
		ejemplo1.setValue(10.0);
		ejemplo2.setValue("Helo");
		ejemplo3.setValue(new Oblong(5, 3));
		
		System.out.println(ejemplo1.getValue());
		System.out.println(ejemplo2.getValue());
		System.out.println(ejemplo3.getValue().calculateArea());
	}
}

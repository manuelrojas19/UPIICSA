package java_chapter13.Generics;


public class SimpleGenericClass<T> { // the angle brackets indicate that this is a generic class
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	
}

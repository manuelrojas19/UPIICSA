package java_chapter14.Exceptions;

import java.io.IOException;

public class AptitudeTest {
	public static void main (String[] args) {
		try {
			int score;
			System.out.println("Ingresa tu puntuaje: ");
			score = TestException.getInteger();
			if (score >= 50) {
				System.out.println("Nopen't");
			} else {
				System.out.println("Nope");
			}
		} catch (NumberFormatException e) {
			System.out.println("Ingresaste un numero no valido");
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("Ciao");
	}
}

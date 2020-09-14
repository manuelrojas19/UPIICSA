package cap15.Java_Collections_Framework;

import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		
		Book b1 = new Book("9999999999", "Clownig Aroud", "Joe King");
		Book b2 = new Book("2222222222", "Farenheit 451", "Fray Rudbury");
		
		books.add(b1);
		books.add(b2);
		
		System.out.print(books);
	}
}

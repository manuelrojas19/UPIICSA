package cap15.Java_Collections_Framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookSort1 {
	public static void main(String[] args) {
		Book b1 = new Book("9999999999", "Clowning Around", "Joe King");
		Book b2 = new Book("2222222222", "Travel With Me", "Sandy Beach");
		Book b3 = new Book("4444444444", "Interior Design", "Anita Room");
		
		List<Book> bookList = new ArrayList<>();
		
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		

		System.out.println("***COMPARABLE DEMO***");
		System.out.println("\nBefore Sort\n"+bookList);
		Collections.sort(bookList);
		System.out.println("\nAfter sort\n"+ bookList);



	}
}

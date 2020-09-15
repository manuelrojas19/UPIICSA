package cap15.Java_Collections_Framework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
	Map <String, Book> books;
	
	public Library() {
		books = new HashMap<>();
	}
	
	public boolean addBook(Book bookIn) {
		String KeyIn = bookIn.getIsbn();
		if (books.containsKey(KeyIn) ) {
			return false;
		}
		else {
			books.put(KeyIn, bookIn);
			return true;
		}
	}
	
	public boolean removeBook(String isbnIn) {
		if (books.remove(isbnIn) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getTotalNumberofBooks() {
		return books.size();
	}
	
	public Book getBook(String isbnIn) {
		return books.get(isbnIn);
	}
	
	public Set<Book> getAllBooks () {
		Set<Book> bookSet = new HashSet<>();
		books.forEach((key, book) -> bookSet.add(book));
		return bookSet;
	}

}

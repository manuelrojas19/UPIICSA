package cap15.Java_Collections_Framework;

public class Book implements Comparable <Book> {
	private String isbn;
	private String title;
	private String author;
	
	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "(" + isbn + ", " + title + ", " + author + ")";
	}

	@Override
	public int hashCode() {
		return isbn.hashCode(); 
	}

	@Override
	public boolean equals(Object objIn) {
		Book bookIn = (Book) objIn;
		return isbn.equals(bookIn.isbn);
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return isbn.compareTo(o.isbn);
	}
	
	

}

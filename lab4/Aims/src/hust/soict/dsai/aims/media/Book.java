package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Arraylist;
import java.util.Arrays;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
	}
	
	public List<String> getAuthors() {
		return authors;
	}

		// Constructor with title, category, cost, authors
		public Book(String title, String category, float cost, String authors) {
			super();
			this.authors.addAll(Arrays.asList(authors));
		}
		
		
		// Constructor with title, category, cost
		public Book(String title, String category, float cost) {
			super();
		}
		
		// Constructor with title
		public Book(String title) {
			super();
		}
public Book(String title, String category, Float cost, List<String> authors2) {
			super();
		}

//Them tac gia moi
public void addAuthor(String authorName) {
	if (authors.contains(authorName)) {//so sanh neu ton tai thi khong them
		System.out.println("The author's name is already in the book");
	}
	else {
		authors.add(authorName); //khong thi them
		System.out.println("The author's name has been successfully added to the book");
	}
}
// Xoa tac gia
public void removeAuthor(String authorName) {
	if(authors.isEmpty()) {//neu author trong thi bao khong co author
		System.out.println("There isn't any author for this book");
	}
	else if (authors.contains(authorName)) {
		authors.remove(authorName);
		System.out.println("The author's name has been successfully removed to the book");//xoa author
	}
	else {
		System.out.println("The author's name is not in the book");//neu khong tim thay author thi bao
	}
}
//toString
@Override
public String toString() {
	String str = String.format("Book - Title:%-20s - Category:%-20s - Author(s):%-20s - Cost:%.2f$", this.getTitle(),
			this.getCategory(), this.getAuthors(), this.getCost());
	return str;
}


}

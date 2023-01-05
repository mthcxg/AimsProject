package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected String director;
	protected int length = 0; // class co 2 fields director va length
//getter

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

// Constructor with title, category, director, length, cost
	public Disc(String title, String category, String director, int length, float cost) {
		super();
		this.length = length;
		this.director = director;
	}

// Constructor with title, category, director, cost
	public Disc(String title, String category, String director, float cost) {
		super();
		this.director = director;
	}

// Constructor with title, category, cost
	public Disc(String title, String category, float cost) {
		super();
	}

// Constructor with title
	public Disc(String title) {
		super();
	}

}

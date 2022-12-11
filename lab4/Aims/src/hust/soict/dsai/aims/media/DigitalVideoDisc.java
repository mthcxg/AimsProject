package hust.soict.dsai.aims.media;

//Mai Thu Hien - 20200203
public class DigitalVideoDisc extends Media implements Playable {
	  private String director;
	  private int length;
	  
	  private static int nbDigitalVideoDisc = 0;
	 //get va set

	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	//Create a DVD object by title
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	//Create a DVD object by title, category, cost
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	//Create a DVD object by title, category, director, cost
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	//Create a DVD object by all
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	}
	 
	
// Implements play method
	@Override
	public void play() {
		if (this.getLength() <= 0) {//neu length = 0 thi khong the choi
			System.out.println("The DVD " + this.getTitle() + " can't be played");
		}
		else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
	}
//toString
	@Override
	public String toString() {
		String str = String.format("DVD - Title:%-20s - Category:%-20s - Director:%-20s - Length:%-20d - Cost:%.2f$", this.getTitle(),
				this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
		return str;
	}	
}



package hust.soict.dsai.aims.disc.DigitalVideoDisc;

//Mai Thu Hien - 20200203
public class DigitalVideoDisc {
	//khai bao bien
	  private String title;
	  private String category;
	  private String director;
	  private int length;
	  private float cost;
	  private int id;
	  private static int nbDigitalVideoDisc = 0;
	 //get va set
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	 public int getId() {
			return id;
	}
	 public void setId(int id) {
			this.id = id;
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
	 
	public String toString() {
    	return ("DVD - " + id + " - " + title + " - " + category + " - " + director + " - " + length + " : " + cost + "$"); 
    }
	

}



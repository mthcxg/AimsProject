package hust.soict.dsai.aims.media;

public class Track implements Playable { //luu thong tin cac track dia cd
	private String title;
	private int length;
	
	public Track() {
		// TODO Auto-generated constructor stub
	}
//getter va setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
//constructor with title, length
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

//implements play method
	@Override
	public void play() {
		if (this.getLength() <= 0) {
			System.out.println("The DVD " + this.getTitle() + " can't be played");
		}
		else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("D length: " + this.getLength());
		}
	}
//equals trong class Track, giong nhau neu co chung title va length
	public boolean equals(Object o) {
		if (!(o instanceof Track)) {
			return false;
		}
		else {
			return (this.getTitle() == ((Track) o).getTitle() & this.getLength() == ((Track) o).getLength());
		}
	}
}

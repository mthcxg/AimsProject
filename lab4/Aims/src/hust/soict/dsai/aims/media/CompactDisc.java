package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {

	}
	public String getArtist() { //getter
		return artist;
	}
public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
	// Constructor with title, category, director, cost, artist, tracks
	public CompactDisc(String title, String category, String director, float cost, String artist, Track[] tracks) {
		super(title, category, director, cost);
		this.artist = artist;
		this.tracks.addAll(Arrays.asList(tracks));
	}
		
// Constructor with title, category, director, cost, artist
	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title, category, director, cost);
		this.artist = artist;
	}
		
// Constructor with title, category, director, cost
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
		
// Constructor with title, category, cost
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
		
// Constructor with title
	public CompactDisc(String title) {
		super(title);
	}

public CompactDisc(String title, String category, String director, String artist2, Float cost) {
		super();
	}
	//addTrack to tracklist
	public void addTrack(Track track) {
		if (track == null) {//neu track bang null bao khong the them vao tracklist
			System.out.println("Can not add a null object to the track list");
		}
		else if (this.tracks.contains(track)) { //neu track da ton tai bao khong the them vao
			System.out.println(String.format("The track %s is already in the track list", track.getTitle()));
		}
		else { // con lai thi them track vao tracklist
			this.tracks.add(track);
			System.out.println(String.format("The track %s has been added to the track list", track.getTitle()));
		}
	}
// Remove track from the tracks list
	public void removeTrack(Track track) {
		if (track == null) {//neu track bang null bao khong the xoa
			System.out.println("Can not remove a null object from the track list");
		}
		else if (!this.tracks.contains(track)) {//neu track khong ton tai trong tracklist thi bao khong the xoa
			System.out.println(String.format("The track %s is not in the track list", track.getTitle()));
		}
		else {// con lai thi xoa track ra khoi tracklist
			this.tracks.remove(track);
			System.out.println(String.format("The track %s has been removed from the track list", track.getTitle()));
		}
	}
//getLength
	public int getLength() {
		int totalLength = 0;
		for (Track track: this.tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
//Implements play method
	@Override
	public void play() {
		if (this.getLength() <= 0) {//neu length <= 0 thi khong the choi
			System.out.println("The DVD " + this.getTitle() + " can't be played");
		}
		else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			for (Track track: this.tracks) {
				track.play();
			}
		}
	}
//toString
	@Override
	public String toString() {
		return String.format("CompactDisc - Title:%-20s - Category:%-20s - Artist:%-20s - Director:%-20s - Length:%-10d - Cost:%.2f$\\n\"", 
				this.getTitle(), this.getCategory(),this.getArtist(), this.getDirector(), this.getLength(), this.getCost());
	}	
}

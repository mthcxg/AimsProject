package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
	public static void main(String[] args ) {
		//Create new store
		Store store = new Store();
		
		//Create new dvd objects 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Himym", "Comedy", 20f);

		//test add method
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		//Test the print method
		store.printDVD();
		//test delete
		store.deleteDVD(dvd1);
		store.printDVD();
	}
}

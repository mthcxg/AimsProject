package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
public class Store {
	//tao 1 store moi
	private ArrayList<DigitalVideoDisc> itemInStore = new ArrayList<DigitalVideoDisc>();
	
	//in ra nhung dvd hien co trong store
	public void printDVD() {
		if(itemInStore.isEmpty()) { // neu khong co gi in store is empty
			System.out.println("Store is empty");
		}
		else {//neu co in ra tat ca cac dvd co trong store
			itemInStore.forEach((item) -> System.out.println(item.toString()));
		}
	}
	//add DVD to store
	public void addDVD(DigitalVideoDisc dvd) {
		if(dvd!= null) { //neu dvd khac null
			itemInStore.add(dvd);
			System.out.println("The dvd has been add to store");
		}
		else {
			System.out.println("Try again");
		}
	}
	
	//delete dvd from store
	public void deleteDVD(DigitalVideoDisc dvd) {
		if(dvd != null) {//neu dvd khac rong
			itemInStore.remove(dvd);
			System.out.println("The dvd has been remove store");
		}
		else {
			System.out.println("Try again");
		}
	}
}


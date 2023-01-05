package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Arrays;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	// tao 1 store moi
	private ArrayList<Media> itemInStore = new ArrayList<Media>();

	// getter
	public ArrayList<Media> getItemInStore() {
		return itemInStore;
	}

	// addMedia them 1 hoac nhieu media vao store
	public void addMedia(Media... medias) {
		for (Media media : medias) {
			itemInStore.add(media);
			System.out.println("The media has been added to the store");
		}
	}

	// removeMedia theo title
	public void removeMedia(Media media) {
		boolean isRemoved = false;
		for (int i = 0; i < itemInStore.size(); i++) {
			if (this.itemInStore.contains(media)) {// neu media trung vs media co trong store
				itemInStore.remove(i);// xoa
				isRemoved = true;
				System.out.println("The media has been removed from the store");
				return;
			}
		}
		if (isRemoved == false) {// neu khong ton tai trong store
			System.out.println("There is no media match");
		}
	}

	// print Store
	public void printStore() {
		for (Media m1 : itemInStore) {
			System.out.println(m1.toString());
		}
	}

	// Search media by title
	public Media searchByTitle(String title) {
		for (Media m : itemInStore) {
			if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
				return m;
			}
		}
		return null;
	}
}
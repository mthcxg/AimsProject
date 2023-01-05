package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class ScreenTest {
	public static void main(String[] args) {

		Store store = new Store();
		Cart cart = new Cart();
		Media dvd1 = new DigitalVideoDisc("Mai Thu Hien", "OOP", 17f);
		Media dvd2 = new DigitalVideoDisc("Mai Thu Hien", "TTUD", 21f);

		Media dvd3 = new DigitalVideoDisc("Mai Thu Hien", "TRR", 35f);
		Media dvd4 = new DigitalVideoDisc("Mai Thu Hien", "CTDL", 54f);

		store.addMedia(dvd1, dvd2, dvd3, dvd4);

		new StoreScreen(store, cart);
	}
}

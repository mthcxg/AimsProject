//Mai Thu Hien -20200203
package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		//create a new cart
		Cart anOrder = new Cart();
		
		//Create new dvd object and add them to cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Himym", "Comedy", 20f);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.removeDigitalVideoDisc(dvd3);
		//anOrder.addDigitalVideoDisc(dvd1, dvd2);
		DigitalVideoDisc[] dvdList = {dvd1,dvd2};
		anOrder.addDigitalVideoDisc(dvdList);
		//print tong gia tien trong gio
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.print();
		//anOrder.searchById(3);
		anOrder.searchByTitle("abc");
	}

}

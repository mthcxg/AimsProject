package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Cart {

  public static final int MAX_NUMBERS_ORDERED = 100; //so luong toi da trong cart
  public ArrayList<Media> itemOrdered = new ArrayList<Media>();//mang luu danh sach

//them 1 media vao cart
  public void addMedia(Media media) {
	  //neu cart chua full va media nay chua ton tai trong cart thi them vao
		if (this.itemOrdered.size() + 1 <= MAX_NUMBERS_ORDERED & !(this.itemOrdered.contains(media))) {
			this.itemOrdered.add(media);
			System.out.println("The media has been added");
		}
		else if (this.itemOrdered.contains(media)) {//neu ton tai trong cart thi khong them
			System.out.println("The media " + media.getTitle() + " is already in the cart");
		}
		else {//neu day thi khong them
			System.out.println("The cart is almost full");
		}
	}


public ArrayList<Media> getItemOrdered() {
	return itemOrdered;
}

	//them 1 list media vao cart
	public void addMedia(Media... medias) {
		if (this.itemOrdered.size() + medias.length <= MAX_NUMBERS_ORDERED) {//neu so luong khong vuot qua cho phep
			for (Media media: medias) {
				if (this.itemOrdered.contains(media)) {//neu da ton tai trong cart thi k them
					System.out.println("The media " + media.getTitle() + " is already in the cart");
				}
				else {//nguoc lai thu them
					this.itemOrdered.add(media);
					System.out.println("The media has been added");
				}
			}
		}
		else {//vuot qua cart thi bao day
			System.out.println("The cart is almost full");
		}
	}
//xoa 1 media ra khoi cart

	public void removeMedia(Media media) {
		if(itemOrdered.contains(media)) {//neu co ton tai thi remove
			itemOrdered.remove(media);
			System.out.println("The media has been removed");
		}
		else {
			System.out.println("Cant remove");
		}
	}
	
	
  // tinh tong gia tien trong cart
  public float totalCost() {
    float total = 0; //khoi tao tong bang 0
    for (int i = 0; i < itemOrdered.size(); i++) {
      total += itemOrdered.get(i).getCost();
    }
    return total;
  }

// Print the list of ordered items of a cart, the pprice of each item, and the total price. 
public void print() {
    System.out.println("***********************CART***********************");
    //neu so luong trong gio > 0
    if (itemOrdered.size() > 0) {
    	System.out.println("Ordered Items:");
    	for(int i = 0; i < itemOrdered.size(); i++) 
    		System.out.println((i+1) + ". " + itemOrdered.get(i).toString()); //i=0
   
    	System.out.println("Total cost: " + totalCost());
    } else { // neu so luong trong gio = 0, in the cart is empty
    	System.out.println("The cart is empty");
    }
    System.out.println("***************************************************");   
}
//sort by title cost
public void sortByTitleCost() {
	Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);
}
//sort by cost title
public void sortByCostTitle() {
	Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
}
//Search media(s) by id 
public Media searchById(int id) {
    for(Media m : itemOrdered) {
        if (m.getId() == id) {
            return m;
        }
    }
    return null;
}
	
	// Search media(s) by matching title 
	public  Media searchByTitle(String title) {
		Media temp = null;
		for (int i = 0; i < itemOrdered.size(); i++) {
			if (itemOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
				temp = itemOrdered.get(i);
			};
		}
		return temp;
	}
}





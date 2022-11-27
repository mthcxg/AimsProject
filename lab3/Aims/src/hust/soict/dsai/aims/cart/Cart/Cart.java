package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Cart {

  public static final int MAX_NUMBERS_ORDERED = 20; //so luong toi da trong cart
  private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];//mang luu danh sach
  public int qtyOrdered = 0; //so luong thuc te
  // them DVD vao cart
  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	  // neu so luong trong cart > max_number thi bao day
    if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
      System.out.println("The cart is full");
    }
    
   // khong thi them dvd vao gio hang
    else {
      itemOrdered[qtyOrdered] = disc;
      qtyOrdered++;
      System.out.println("The disc is added");
    }
  }
  //overloading by differing types of parameter
  //Mai Thu Hien - 20200203
  public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
	  for(DigitalVideoDisc dvd : dvdList) {
		  this.addDigitalVideoDisc(dvd);
	  }
  }
  // Overloading by differing the number of parameters
  public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) { 
      this.addDigitalVideoDisc(dvd1);
      this.addDigitalVideoDisc(dvd2);
  }

  // xoa dvd 
  public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
	  // neu khong co dvd thi bao trong
    if (qtyOrdered == 0) {
      System.out.println("The cart is empty");
    } 
    // neu co, tim index dvd nay
    else {
      int id = -1; //khong co = -1
      for (int i = 0; i < qtyOrdered; i++) {
        if (itemOrdered[i].equals(disc)) {
          id = i;
        }
      }

      if (id != -1) { //neu ton tai
        for (int i = id; i < qtyOrdered; i++) {
          itemOrdered[i] = itemOrdered[i + 1]; // cho A[i] = A[i+1]
        }
        System.out.println("The disc has been removed");
        qtyOrdered--; //xoa bot 1 phan tu
      } else {
        System.out.println("The disc isn't in this cart");
      }
    }
  }
 


  // tinh tong gia tien trong cart
  public float totalCost() {
    float total = 0; //khoi tao tong bang 0
    for (int i = 0; i < qtyOrdered; i++) {
      total += itemOrdered[i].getCost();
    }
    return total;
  }

// Print the list of ordered items of a cart, the pprice of each item, and the total price. 
public void print() {
    System.out.println("***********************CART***********************");
    //neu so luong trong gio > 0
    if (qtyOrdered > 0) {
    	System.out.println("Ordered Items:");
    	for(int i = 0; i < qtyOrdered; i++) 
    		System.out.println((i+1) + ". " + itemOrdered[i].toString()); //i=0
   
    	System.out.println("Total cost: " + totalCost());
    } else { // neu so luong trong gio = 0, in the cart is empty
    	System.out.println("The cart is empty");
    }
    System.out.println("***************************************************");   
}
//Search for DVDs in the cart by ID
public void searchById(int id) {
	System.out.println("Search for DVDs in the cart By Id: " + id);
	int index = -1;
	for(int i = 0; i < qtyOrdered; i++) {
		if(id == itemOrdered[i].getId()) { //tim thay 
			index = i; //index = i
			break;
		}
	}
	if(index != -1) {
		System.out.println("Found");
		System.out.println((index+1) + ". " + itemOrdered[index].toString());
	} else {
		System.out.println("Not Found");
	}
}

//Search for DVDs in the cart by Title
public void searchByTitle(String title) {
	System.out.println("Search for DVDs in the by title: " + title);
	int index = -1;
	for(int i = 0; i < qtyOrdered; i++) {
		if(itemOrdered[i].getTitle().equals(title)) {
			index = i;//tim thay cho index = i
			break;
		}
	}
	if(index != -1) { //neu index = i
		System.out.println("Found");
		System.out.println((index+1) + ". " + itemOrdered[index].toString());
	} else {
		System.out.println("Not Found");
	}
}
}




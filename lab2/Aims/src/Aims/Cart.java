package Aims;
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
}
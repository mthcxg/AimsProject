//Mai Thu Hien 20200203
//giai pt bac 2 ax^2 + bx + c = 0
import java.util.*;  
public class ptbac2 {
    public static void main(String[] args){
        String a, b, c;
        Scanner sc= new Scanner(System.in); 
        System.out.println("Nhap he so phuong trinh bac nhat co dang ax^2 + bx + c = 0");
        System.out.print("Nhap a: ");  
        a = sc.nextLine(); //doc he so a nguoi dung nhap 
        System.out.print("Nhap b: ");  
        b = sc.nextLine();  //doc he so b nguoi dung nhap
        System.out.print("Nhap c: ");  
        c = sc.nextLine();  //doc he so c nguoi dung nhap
        String pt;
        pt = a + "x^2 " + "+ " + b + "x " + "+ "+ c  + " = " + "0";
        System.out.println("Phuong trinh cua ban la: " + pt);
        float a1 = Float.parseFloat(a); //doi string thanh float
        float b1 = Float.parseFloat(b);
        float c1 = Float.parseFloat(c);
        if (a1 == 0) {
            if (b1 == 0) {
                System.out.println("Phuong trinh vo nghiem!");
            } else {
                System.out.println("Phuong trinh co 1 nghiem: " + "x = " + (-c1 / b1));
            }
            return;
        }
        //tinh delta = b^2 - 4ac
        float delta = b1*b1 - 4*a1*c1; 
        float x1, x2; //nghiem
        if (delta > 0) { //neu delta > 0 pt co 2 no phan biet
            x1 = (float) ((-b1 + Math.sqrt(delta)) / (2*a1));
            x2 = (float) ((-b1 - Math.sqrt(delta)) / (2*a1));
            System.out.println("Phuong trinh co 2 nghiem phan biet: " + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) { //delta = 0 pt co no kep
            x1 = (-b1 / (2 * a1));
            System.out.println("Phuong trinh co nghiem kep: " + "x1 = x2 = " + x1);
        } else { //delta < 0 vo nghieem
            System.out.println("Phuong trinh vo nghiem!");
        }
    }
}

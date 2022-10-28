//Mai Thu Hien 20200203
//Giai pt bac 1
import java.util.*;  
public class ptbac1 {
    public static void main(String[] args){
        String a, b;
        Scanner sc= new Scanner(System.in); 
        System.out.println("Nhap he so phuong trinh bac nhat co dang ax + b = 0");
        System.out.print("Nhap a: ");  
        a = sc.nextLine(); //doc he so a nguoi dung nhap 
        System.out.print("Nhap b: ");  
        b = sc.nextLine();  //doc he so b nguoi dung nhap
        String pt;
        pt = a + "x "+ "+ "  + b  + " = " + "0";
        System.out.println("Phuong trinh cua ban la: " + pt);
        float a1 = Float.parseFloat(a); //doi string thanh float
        float b1 = Float.parseFloat(b);
        if (a1 == 0){
            if (b1 == 0) System.out.print("Phuong trinh vo so nghiem"); //neu a = 0 b = 0 pt vo so nghiem
            else if (b1 != 0) System.out.print("Phuong trinh vo nghiem");} //a = 0 b khac 0 pt vo nghiem
            else{
                System.out.print("Nghiem cua phuong trinh la: " + (-b1/a1));} //pt co no la -b/a
        }
        
}


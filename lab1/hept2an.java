//Mai Thu Hien 20200203
//giai he pt 2 an a1x + b1y = c1 a2x + b2y = c2
import java.util.*;  
public class hept2an {
    public static void main(String[] args){
        String a1Num, a2Num, b1Num, b2Num, c1Num, c2Num;
        Scanner sc= new Scanner(System.in); 
        System.out.println("Nhap he so phuong trinh bac nhat co dang a1x + b1y = c1 // a2x + b2y = c2");
        System.out.print("Nhap a1: ");  a1Num = sc.nextLine(); //doc he so nguoi dung nhap 
        System.out.print("Nhap b1: ");  b1Num = sc.nextLine();  
        System.out.print("Nhap c1: ");  c1Num = sc.nextLine();  
        System.out.print("Nhap a2: ");  a2Num = sc.nextLine(); 
        System.out.print("Nhap b2: ");  b2Num = sc.nextLine();  
        System.out.print("Nhap c2: ");  c2Num = sc.nextLine();  
        String pt1, pt2;
        pt1 = a1Num + "x "+ "+ "  + b1Num + "y "  + " = " + c1Num;
        pt2 = a2Num + "x "+ "+ "  + b2Num + "y "  + " = " + c2Num;
        System.out.println("He phuong trinh cua ban la: " + pt1 + " // " + pt2);
        float a1 = Float.parseFloat(a1Num); //doi string thanh float
        float b1 = Float.parseFloat(b1Num);
        float c1 = Float.parseFloat(c1Num);
        float a2 = Float.parseFloat(a2Num); 
        float b2 = Float.parseFloat(b2Num);
        float c2 = Float.parseFloat(c2Num);
        //giai bang dinh thuc
        //D = a1b2 - a2b1
        //Dx = c1b2 - c2b1
        //Dy = a1c2 - a2c1
        //D = Dx = Dy = 0 thi he vo so nghiem, D = 0, Dx hoac Dy khac 0  thi he vo nghiem
        //D khac 0 thi he co 1 nghiem x = Dx/D, y = Dy/D3
        float D = a1*b2 - a2*b1;
        float Dx = c1*b2 - c2*b1;
        float Dy = a1*c2 - a2*c1;
        if (D == 0){
            if(Dx == 0 && Dy == 0){ //D = Dx = Dy = 0
                System.out.print("Phuong trinh vo so nghiem");
            }
            else{ //D = 0, Dx hoac Dy khac 0
                System.out.print("Phuong trinh vo nghiem");
            }
        }
        else{ //D khac 0
            System.out.print("He co 1 nghiem" + " x = " + (Dx/D) + "," +  " " + "y = " + (Dy/D));
        }
    }
    
}

//Mai Thu Hien - 20200203
//2.5
//tinh tong hieu tich thuong cua 2 so do nguoi dung nhap
import java.util.*;  
public class caculate1 {
    public static void main(String[] args){
        String strNum1, strNum2;
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter number 1: ");  
        strNum1 = sc.nextLine(); //doc string ng dung nhap = strNum1
        System.out.print("Enter number 2: ");  
        strNum2 = sc.nextLine();  //doc string nguoi dung nhap = strNum2
        
        double num1 = Double.parseDouble(strNum1); //chuyen string thanh double
        double num2 = Double.parseDouble(strNum2);
        double sum, minus, div, mul;
        sum = num1 + num2;
        minus = num1 - num2;
        div = num1/num2;
        mul = num1*num2;
        
        System.out.println("Tong 2 so la: "+ sum ); 
        System.out.println("Hieu 2 so la: "+ minus); 
        System.out.println("Thuong 2 so la: "+ div);
        System.out.println("Tich 2 so la: "+ mul);
        System.exit(0);
    }
}


import java.util.*;  
public class caculate1 {
    public static void main(String[] args){
        String strNum1, strNum2;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number 1: ");  
        strNum1 = sc.nextLine(); 
        System.out.print("Enter number 2: ");  
        strNum2 = sc.nextLine(); 
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum, minus, div, mul;
        sum = num1 + num2;
        minus = num1 - num2;
        div = num1/num2;
        mul = num1*num2;
        
        System.out.print("Tong 2 so la: "+ sum ); 
        System.out.print("\n");
        System.out.print("Hieu 2 so la: "+ minus); 
        System.out.print("\n");
        System.out.print("Thuong 2 so la: "+ div);
        System.out.print("\n");
        System.out.print("Tich 2 so la: "+ mul);
        System.exit(0);
    }
}

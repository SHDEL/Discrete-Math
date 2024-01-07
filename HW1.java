// package homework;
import java.util.Scanner;
public class HW1 {
    public static void main(String[] args) {
        System.out.println("-----------Q1 Division program----------");
        System.out.println("Equation: a = d(q) + r");
        System.out.println("assign a and d and you will get equation");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.close();
        divisionProcess(num1, num2);
    }
    static void divisionProcess(int num1, int num2){
        int tmp = num1;
        int cnt = 0;
        while (true){
            if(num1 <= num2){
                break;
            }
            num1 = num1 - num2;
            cnt++;
            // System.out.println(num1);
        }
        System.out.println("----------------------------");
        // System.out.println("count = " + cnt);
        
        System.out.println("Equation: " + tmp + " = (" + num2 + " x " + cnt + ") + " + num1);
    }  
}
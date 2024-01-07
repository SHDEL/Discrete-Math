import java.util.Scanner;
public class HW2gcd {
    public static void main(String[] args) {
        System.out.println("----Find gcd program----");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers to find gcd: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("gcd(" + num1 + ", " + num2 +")");
        gcdFind(num1, num2);
        sc.close();
    }
    static void gcdFind(int num1, int num2){
        while (true) {
            if (num1 % num2 == 0){
                System.out.println("gcd(" + num2 + ", " + 0 +")");
                System.out.println("gcd = " + num2);
                break;
            }
            int a = division(num1, num2); //a = num1 (ces)
            System.out.println("gcd(" + num2 + ", " + a + ")");
            num1 = num2;
            num2 = a;
        }
    }
    static int division(int num1, int num2){
        // int tmp = num1;
        while (true){
            if(num1 <= num2){
                break;
            }
            num1 = num1 - num2;
        }
        return num1;
    }

    
}
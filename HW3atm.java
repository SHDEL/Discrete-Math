import java.util.Scanner;
public class HW3atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Welcome to CS KMTIL ATM-----");
        System.out.print("Enter amount to deposit: ");
        int deposit = sc.nextInt();
        ATM acc1 = new ATM(deposit);
        // System.out.println();
        System.out.print("Enter amount to withdraw: ");
        int draw = sc.nextInt();
        acc1.withDraw(draw);
        sc.close();
    }
}
class ATM {
    private int amount;
    private int cash1000;
    private int cash500;
    private int cash100;

    public ATM(int input){
        amount = input;
    }
    public void withDraw(int input){
        System.out.println("----Banknote Withdraw-----");
        this.amount -= input;
        if (input >= 1000){
            this.cash1000 = input / 1000;
            input -= this.cash1000 * 1000;
        }
        if (input >= 500){
            this.cash500 = input / 500;
            input -= this.cash500 * 500;
        }
        if (input >= 100){
            this.cash100 = input / 100;
            input -= this.cash100 * 100;
        }
        System.out.println("1000 Bath bill: " + this.cash1000 + " bills");
        System.out.println("500 Bath bill: " + this.cash500 + " bills");
        System.out.println("100 Bath bill: " + this.cash100 + " bills");
        System.out.println("amount in account: " + this.amount + " Bath");
    }
}

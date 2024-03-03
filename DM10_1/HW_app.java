package DM10_1;

import java.util.Scanner;

public class HW_app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix: ");
        String input = sc.nextLine();
        input = input.replaceAll(" ", "");
        System.out.println("Infix: " + input);
        Posfix p1 = new Posfix(input);
        p1.infixToPostfix();
        sc.close();
    }
}

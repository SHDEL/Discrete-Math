package DM10_1;
import java.util.Scanner;
public class HW_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------Find Power Matrix program-------");
        System.out.println("Enter row and col");
        System.out.print("Enter row: ");
        int m = sc.nextInt();
        System.out.print("Enter col: ");
        int n = sc.nextInt();
        Matrix cal = new Matrix(m, n);
        int [][] data = new int[m][n];
        System.out.println("------Enter num in matrix------");
        for (int row = 0; row < data.length; row++){
            System.out.print("Enter num in row " + (row + 1) + " : ");
            for (int col = 0; col < data[0].length; col++){
                data[row][col] = sc.nextInt();
            }
        }
        cal.setMatrix(data);
        System.out.print("Enter n of power: ");
        int pow = sc.nextInt();
        cal.powerMatrix(pow);
        sc.close();
    }
}
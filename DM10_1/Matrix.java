package DM10_1;
import java.util.Arrays;
public class Matrix {
    private int row;
    private int col;
    private int [][] matrix;
    private int pow;
    private int [][] ans;
    Matrix(int m, int n){
        row = m;
        col = n;
        matrix = new int[row][col];
        ans = new int[row][col];
    }
    public void setMatrix(int [][] data){
        for (int row = 0; row < matrix.length; row++){
            matrix[row] = data[row].clone();
        }
        System.out.println("Matrix : ");
        for (int [] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
    public void powerMatrix(int n){
        pow = n;
        for (int i = 1; i < pow; i++){
            if (i > 1){
                matrix = ans;
            }
            int [][] temp = new int[row][col];
            for (int row = 0; row < matrix.length; row++){
                for (int col = 0; col < matrix[row].length; col++){
                    int sum = 0;
                    for (int k = 0; k < matrix.length; k++){
                        sum += matrix[row][k] * matrix[k][col];
                    }
                    temp[row][col] = sum;
                }
            }
            ans = temp;
        }
        System.out.println("Matrix power " + pow + " is: ");
        for (int [] row : ans){
            System.out.println(Arrays.toString(row));
        }

    }
}

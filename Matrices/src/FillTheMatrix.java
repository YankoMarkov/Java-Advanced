import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol = read.readLine().split(", ");
        int rows = Integer.valueOf(rowCol[0]);
        int cols = Integer.valueOf(rowCol[0]);
        int[][] matrix = new int[rows][cols];

        if (rowCol[1].equals("A")) {
            methodA(matrix, rows, cols);
        }
        if (rowCol[1].equals("B")) {
            methodB(matrix, rows, cols);
        }
    }

    private static void methodA(int[][] matrix, int row, int col) {
        int num = 1;
        for (int cols = 0; cols < col; cols++) {
            for (int rows = 0; rows < row; rows++) {
                matrix[rows][cols] = num;
                num++;
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    private static void methodB(int[][] matrix, int row, int col) {
        boolean turn = true;
        int num = 1;
        for (int cols = 0; cols < col; cols++) {
            if (turn) {
                for (int rows = 0; rows < row; rows++) {
                    matrix[rows][cols] = num;
                    num++;
                    turn = false;
                }
            } else {
                for (int rows = row - 1; rows >= 0; rows--) {
                    matrix[rows][cols] = num;
                    num++;
                    turn = true;
                }
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }
}

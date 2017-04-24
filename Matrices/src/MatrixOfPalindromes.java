import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOfPalindromes {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol = read.readLine().split(" ");
        int rows = Integer.valueOf(rowCol[0]);
        int cols = Integer.valueOf(rowCol[1]);
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = "" + (char) ('a' + row) + (char) ('a' + row + col) + (char) ('a' + row);
            }
        }
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s ", string);
            }
            System.out.println();
        }
    }
}

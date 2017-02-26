
import java.util.Scanner;

public class TargetPractice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rowCol = scan.nextLine().split("\\s+");
        int rows = Integer.valueOf(rowCol[0]);
        int cols = Integer.valueOf(rowCol[1]);
        String word = scan.nextLine();
        String[] shotArgs = scan.nextLine().split("\\s+");
        int shotRow = Integer.valueOf(shotArgs[0]);
        int shotCol = Integer.valueOf(shotArgs[1]);
        int shotRadius = Integer.valueOf(shotArgs[2]);
        char[][] matrix = new char[rows][cols];

        boolean isMovingLeft = true;
        int index = 0;
        for (int row = rows - 1; row >= 0; row--) {
            if (isMovingLeft) {
                for (int col = cols - 1; col >= 0; col--) {
                    matrix[row][col] = word.charAt(index);
                    index = (index + 1) % word.length();
                }
            } else {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = word.charAt(index);
                    index = (index + 1) % word.length();
                }
            }
            isMovingLeft = !isMovingLeft;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean isInRange = Math.pow(shotRow - row, 2) + Math.pow(shotCol - col, 2) <= Math.pow(shotRadius, 2);
                if (isInRange) {
                    matrix[row][col] = ' ';
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                if (matrix[row][col] == ' ') {
                    int rowToSlide = row - 1;
                    while (matrix[row][col] == ' ' && rowToSlide >= 0) {
                        matrix[row][col] = matrix[rowToSlide][col];
                        matrix[rowToSlide][col] = ' ';
                        rowToSlide--;
                    }
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] aMatrix : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%s", aMatrix[col]);
            }
            System.out.println();
        }
    }
}

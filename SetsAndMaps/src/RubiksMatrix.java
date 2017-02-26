
import java.util.Scanner;

public class RubiksMatrix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] rc = scan.nextLine().split("\\s+");
        int rows = Integer.valueOf(rc[0]);
        int cols = Integer.valueOf(rc[1]);
        int[][] matrix = new int[rows][cols];
        int n = Integer.valueOf(scan.nextLine());

        for (int i = 0; i < rows * cols; i++) {
            matrix[i / cols][i % rows] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split("\\s+");
            int index = Integer.valueOf(command[0]);
            int move = Integer.valueOf(command[2]);

            switch (command[1]) {
                case "left" :
                    swapRow(matrix, index, move % cols, cols);
                    break;
                case "right" :
                    swapRow(matrix, index, cols - move % cols, cols);
                    break;
                case "up" :
                    swapCol(matrix, index, move % rows, rows);
                    break;
                case "down" :
                    swapCol(matrix, index, rows - move % rows, rows);
                    break;
            }
        }
        arrange(matrix, rows, cols);
    }

    private static void swapRow(int[][] matrix, int row, int move, int cols) {
        int[] temp = new int[cols];
        for (int index = 0; index < temp.length; index++) {
            temp[index] = matrix[row][(index + move) % cols];
        }
        System.arraycopy(temp, 0, matrix[row], 0, temp.length);
    }

    private  static void swapCol(int[][] matrix, int col, int move, int rows) {
        int[] temp = new int[rows];
        for (int index = 0; index < temp.length; index++) {
            temp[index] = matrix[(index + move) % rows][col];
        }
        for (int index = 0; index < temp.length; index++) {
            matrix[index][col] = temp[index];
        }
    }

    private static void arrange(int[][] matrix, int rows, int cols) {
        int expected = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != expected) {
                    for (int x = 0; x < rows; x++) {
                        for (int y = 0; y < cols; y++) {
                            if (matrix[x][y] == expected) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)\n", row, col, x, y);
                                int temp = matrix[x][y];
                                matrix[x][y] = matrix[row][col];
                                matrix[row][col] = temp;
                            }
                        }
                    }
                } else {
                    System.out.println("No swap required");
                }
                expected++;
            }
        }
    }
}

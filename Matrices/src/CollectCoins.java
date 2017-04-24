import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectCoins {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int rows = 4;
        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = read.readLine().toCharArray();
        }
        String command = read.readLine();
        int coinCount = 0;
        int wallCount = 0;
        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < command.length(); i++) {
            char symbol = command.charAt(i);
            switch (symbol) {
                case '>':
                    if (startCol + 1 >= matrix[startRow].length) {
                        wallCount++;
                        continue;
                    }
                    if (matrix[startRow][startCol + 1] == '$') {
                        coinCount++;
                        startCol++;
                    } else {
                        startCol++;
                    }
                    break;
                case '<':
                    if (startCol - 1 < 0) {
                        wallCount++;
                        continue;
                    }
                    if (matrix[startRow][startCol - 1] == '$') {
                        coinCount++;
                        startCol--;
                    } else {
                        startCol--;
                    }
                    break;
                case '^':
                    if (startRow - 1 < 0 || matrix[startRow - 1].length < startCol) {
                        wallCount++;
                        continue;
                    }
                    if (matrix[startRow - 1][startCol] == '$') {
                        coinCount++;
                        startRow--;
                    } else {
                        startRow--;
                    }
                    break;
                case 'V':
                    if (startRow + 1 >= matrix.length || matrix[startRow + 1].length < startCol) {
                        wallCount++;
                        continue;
                    }
                    if (matrix[startRow + 1][startCol] == '$') {
                        coinCount++;
                        startRow++;
                    } else {
                        startRow++;
                    }
                    break;
            }
        }
        System.out.printf("Coins = %d\nWalls = %d\n", coinCount, wallCount);
    }
}

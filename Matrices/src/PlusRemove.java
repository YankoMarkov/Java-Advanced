import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlusRemove {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String inputs = null;
        List<String> input = new ArrayList<>();

        while (!(inputs = read.readLine()).equals("END")) {
            input.add(inputs);
        }
        char[][] matrix = new char[input.size()][];
        char[][] tempMatrix = new char[input.size()][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = input.get(row).toCharArray();
            tempMatrix[row] = input.get(row).toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < input.get(row).length(); col++) {
                tempMatrix[row][col] = ' ';
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            String top = "";
            String middleLeft = "";
            String middleCentre = "";
            String middleRight = "";
            String bottom = "";
            for (int col = 0; col < matrix[row].length; col++) {
                top = Character.toString(matrix[row][col]).toLowerCase();
                if (row + 2 > matrix.length - 1 || matrix[row + 2].length - 1 < col) {
                    continue;
                } else {
                    bottom = Character.toString(matrix[row + 2][col]).toLowerCase();
                }
                if (col - 1 < 0 || row + 1 > matrix.length - 1) {
                    continue;
                } else {
                    middleLeft = Character.toString(matrix[row + 1][col - 1]).toLowerCase();
                }
                if (col + 1 > matrix[row + 1].length - 1) {
                    continue;
                } else {
                    middleRight = Character.toString(matrix[row + 1][col + 1]).toLowerCase();
                }
                if (row + 1 > matrix.length - 1 || matrix[row + 1].length - 1 < col) {
                    continue;
                } else {
                    middleCentre = Character.toString(matrix[row + 1][col]).toLowerCase();
                }
                if (top.equals(middleLeft) && top.equals(middleCentre) &&
                        top.equals(middleRight) && top.equals(bottom)) {
                    tempMatrix[row][col] = matrix[row][col];
                    tempMatrix[row + 1][col - 1] = matrix[row + 1][col - 1];
                    tempMatrix[row + 1][col] = matrix[row + 1][col];
                    tempMatrix[row + 1][col + 1] = matrix[row + 1][col + 1];
                    tempMatrix[row + 2][col] = matrix[row + 2][col];
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder result = new StringBuilder();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != tempMatrix[row][col]) {
                    result = result.append(matrix[row][col]);
                }
            }
            System.out.println(result);
        }
    }
}

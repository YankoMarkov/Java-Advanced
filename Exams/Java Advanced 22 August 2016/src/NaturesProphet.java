import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NaturesProphet {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int[] rowsCols = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[][] matrix = new int[rowsCols[0]][rowsCols[1]];

        String inputs = null;
        while (!(inputs = read.readLine()).equals("Bloom Bloom Plow")) {
            String[] input = inputs.split(" ");
            int rows = Integer.valueOf(input[0]);
            int cols = Integer.valueOf(input[1]);
    
            for (int col = 0; col < matrix[rows].length; col++) {
                if (col == cols) {
                    continue;
                }
                matrix[rows][col] += 1;
            }
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][cols] += 1;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] rowCol = read.readLine().split(" ");
		int rows = Integer.valueOf(rowCol[0]);
		int cols = Integer.valueOf(rowCol[1]);
		int[][] matrix = new int[rows][cols];
		
		for (int row = 0; row < matrix.length; row++) {
			matrix[row] = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		}
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int startRow = 0;
		int startCol = 0;
		for (int row = 0; row < matrix.length - 2; row++) {
			for (int col = 0; col < matrix[row].length - 2; col++) {
				sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
						matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
						matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
				if (sum > maxSum) {
					startRow = row;
					startCol = col;
					maxSum = sum;
				}
			}
		}
		System.out.println("Sum = " + maxSum);
		for (int row = startRow; row < startRow + 3; row++) {
			for (int col = startCol; col < startCol + 3; col++) {
				System.out.printf("%d ", matrix[row][col]);
			}
			System.out.println();
		}
	}
}

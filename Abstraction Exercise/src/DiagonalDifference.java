import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		int[][] matrix = new int[num][num];
		
		for (int row = 0; row < num; row++) {
			matrix[row] = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		}
		int sum = 0;
		int sum1 = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (row == col) {
					sum += matrix[row][col];
				}
				if (row == (matrix[row].length - 1) - col) {
					sum1 += matrix[row][col];
				}
			}
		}
		int total = Math.abs(sum - sum1);
		System.out.println(total);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] rowsCols = read.readLine().split(", ");
		int row = Integer.valueOf(rowsCols[0]);
		int col = Integer.valueOf(rowsCols[1]);
		
		int[][] matrix = new int[row][col];
		for (int i = 0; i < matrix.length; i++) {
			int[] rows = Arrays.stream(read.readLine().split(", ")).mapToInt(Integer::valueOf).toArray();
			matrix[i] = rows;
		}
		int sum = 0;
		for (int[] ints : matrix) {
			for (int anInt : ints) {
				sum += anInt;
			}
		}
		System.out.println(row);
		System.out.println(col);
		System.out.println(sum);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquaresInMatrix2x2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] rowCol = read.readLine().split("\\s+");
		int row = Integer.valueOf(rowCol[0]);
		int col = Integer.valueOf(rowCol[1]);
		String[][] matrix = new String[row][col];
		
		for (int rows = 0; rows < row; rows++) {
			matrix[rows] = read.readLine().split("\\s+");
		}
		int count = 0;
		for (int rows = 0; rows < matrix.length - 1; rows++) {
			for (int cols = 0; cols < matrix[rows].length - 1; cols++) {
				if (matrix[rows][cols].equals(matrix[rows][cols + 1]) &&
						matrix[rows + 1][cols].equals(matrix[rows + 1][cols + 1]) &&
						matrix[rows][cols].equals(matrix[rows + 1][cols])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

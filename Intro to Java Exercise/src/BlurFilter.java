import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BlurFilter {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int blurAmount = Integer.valueOf(read.readLine());
		String[] matrixSize = read.readLine().split("\\s+");
		int row = Integer.valueOf(matrixSize[0]);
		int col = Integer.valueOf(matrixSize[1]);
		
		long[][] matrix = new long[row][col];
		
		for (int i = 0; i < matrix.length; i++) {
			long[] rows = Arrays.stream(read.readLine().split("\\s+")).mapToLong(Long::valueOf).toArray();
			matrix[i] = rows;
		}
		String[] indexes = read.readLine().split("\\s+");
		int rowIndex = Integer.valueOf(indexes[0]);
		int colIndex = Integer.valueOf(indexes[1]);
		
		int startRow = Math.max(0, rowIndex - 1);
		int endRow = Math.min(row - 1, rowIndex + 1);
		
		int startCol = Math.max(0, colIndex - 1);
		int endCol = Math.min(col - 1, colIndex + 1);
		
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
			matrix[i][j] += blurAmount;
			}
		}
		for (long[] longs : matrix) {
			for (long aLong : longs) {
				System.out.print(aLong + " ");
			}
			System.out.println();
		}
	}
}

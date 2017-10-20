import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixShuffling {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] rowCol = read.readLine().split("\\s+");
		int rows = Integer.valueOf(rowCol[0]);
		int cols = Integer.valueOf(rowCol[1]);
		String[][] matrix = new String[rows][cols];
		
		for (int row = 0; row < matrix.length; row++) {
			matrix[row] = read.readLine().split("\\s+");
		}
		String commands = null;
		while (!(commands = read.readLine()).equals("END")) {
			int row1 = 0;
			int col1 = 0;
			int row2 = 0;
			int col2 = 0;
			if (commands.startsWith("swap")) {
				String[] command = commands.split("\\s+");
				if (command.length != 5) {
					System.out.println("Invalid input!");
					continue;
				}
				row1 = Integer.valueOf(command[1]);
				col1 = Integer.valueOf(command[2]);
				row2 = Integer.valueOf(command[3]);
				col2 = Integer.valueOf(command[4]);
			} else {
				System.out.println("Invalid input!");
				continue;
			}
			if (row1 < 0 || row1 >= matrix.length ||
					row2 < 0 || row2 >= matrix.length ||
					col1 < 0 || col1 >= matrix[row1].length ||
					col2 < 0 || col2 >= matrix[row2].length) {
				System.out.println("Invalid input!");
			} else {
				String temp = matrix[row1][col1];
				matrix[row1][col1] = matrix[row2][col2];
				matrix[row2][col2] = temp;
				for (int row = 0; row < matrix.length; row++) {
					for (int col = 0; col < matrix[row].length; col++) {
						System.out.printf("%s ", matrix[row][col]);
					}
					System.out.println();
				}
			}
		}
	}
}

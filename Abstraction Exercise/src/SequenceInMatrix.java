import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceInMatrix {
	
	private static int sequenceCount = 0;
	private static String sequenceSymbol = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] rowCol = read.readLine().split(" ");
		int rows = Integer.valueOf(rowCol[0]);
		int cols = Integer.valueOf(rowCol[1]);
		String[][] matrix = new String[rows][];
		
		for (int row = 0; row < matrix.length; row++) {
			matrix[row] = read.readLine().split(" ");
		}
		
		List<String> sequence = new ArrayList<>();
		
		//by line
		for (int row = 0; row < matrix.length; row++) {
			sequence.addAll(Arrays.asList(matrix[row]));
			checkForSequence(sequence);
		}
		
		//by column
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				sequence.add(matrix[row][col]);
			}
			checkForSequence(sequence);
		}
		
		//by diagonal
		int diagonalSize = Math.min(rows, cols);
		for (int diag = 0; diag < diagonalSize; diag++) {
			sequence.add(matrix[diag][diag]);
		}
		checkForSequence(sequence);
		
		List<String> res = new ArrayList<>();
		for (int i = 0; i < sequenceCount; i++) {
			res.add(sequenceSymbol);
		}
		String result = res.stream()
				.collect(Collectors.joining(", "));
		System.out.println(result);
	}
	
	private static void checkForSequence(List<String> sequence) {
		for (int start = 0; start < sequence.size() - 1; start++) {
			int counter = 1;
			int position = start + 1;
			String symbol = sequence.get(start);
			
			while (symbol.equals(sequence.get(position))) {
				counter++;
				if (counter >= sequenceCount) {
					sequenceCount = counter;
					sequenceSymbol = symbol;
				}
				position++;
				if (position >= sequence.size()) {
					break;
				}
			}
		}
		sequence.clear();
	}
}

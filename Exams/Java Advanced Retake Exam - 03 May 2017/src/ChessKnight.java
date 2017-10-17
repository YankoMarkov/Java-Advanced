import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessKnight {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[][] matrix = new String[8][8];
		List<String> getPieces = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = read.readLine().split("[|]");
		}
		int invalidMove = 0;
		int boardOut = 0;
		String inputs;
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split(" -> ");
			if (input.length == 1) {
				continue;
			}
			String from = input[0];
			String to = input[1];
			int rowFrom = Integer.valueOf(Character.toString(from.charAt(0)));
			int colFrom = Integer.valueOf(Character.toString(from.charAt(1)));
			int rowTo = Integer.valueOf(Character.toString(to.charAt(0)));
			int colTo = Integer.valueOf(Character.toString(to.charAt(1)));
			
			if (rowTo > 7 || rowTo < 0 || colTo > 7 || colTo < 0) {
				boardOut++;
				continue;
			}
			int rowdiff = Math.abs(rowFrom - rowTo);
			int coldiff = Math.abs(colFrom - colTo);
			if ((rowdiff == 2 && coldiff == 1) || (rowdiff == 1 && coldiff == 2)) {
				if (!matrix[rowTo][colTo].equals(" ")) {
					getPieces.add(matrix[rowTo][colTo]);
				}
			} else {
				invalidMove++;
			}
		}
		System.out.print("Pieces take: ");
		System.out.println(Arrays.toString(getPieces.toArray()).replaceAll("[\\[\\]]", ""));
		System.out.printf("Invalid moves: %d%n", invalidMove);
		System.out.printf("Board out moves: %d", boardOut);
	}
}

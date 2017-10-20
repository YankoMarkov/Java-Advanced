import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusRemove1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs = null;
		List<char[]> originalMatrix = new ArrayList<>();
		List<char[]> copyMatrix = new ArrayList<>();
		
		while (!(inputs = read.readLine()).equals("END")) {
			originalMatrix.add(inputs.toCharArray());
			copyMatrix.add(inputs.toUpperCase().toCharArray());
		}
		manipulateMatrix(originalMatrix, copyMatrix);
		printMatrix(originalMatrix);
	}
	
	private static void printMatrix(List<char[]> originalMatrix) {
		for (char[] matrix : originalMatrix) {
			System.out.println(Arrays.toString(matrix).replaceAll("[\\[\\], \0]", ""));
		}
	}
	
	private static void manipulateMatrix(List<char[]> originalMatrix, List<char[]> copyMatrix) {
		for (int i = 0; i < originalMatrix.size(); i++) {
			for (int j = 0; j < originalMatrix.get(i).length; j++) {
				try {
					char top = copyMatrix.get(i)[j];
					char middleLeft = copyMatrix.get(i + 1)[j - 1];
					char middleCentre = copyMatrix.get(i + 1)[j];
					char middleRight = copyMatrix.get(i + 1)[j + 1];
					char bottom = copyMatrix.get(i + 2)[j];
					if (top == middleLeft && top == middleCentre && top == middleRight && top == bottom) {
						originalMatrix.get(i)[j] = '\0';
						originalMatrix.get(i + 1)[j - 1] = '\0';
						originalMatrix.get(i + 1)[j] = '\0';
						originalMatrix.get(i + 1)[j + 1] = '\0';
						originalMatrix.get(i + 2)[j] = '\0';
					}
				} catch (IndexOutOfBoundsException e) {
				}
			}
		}
	}
}

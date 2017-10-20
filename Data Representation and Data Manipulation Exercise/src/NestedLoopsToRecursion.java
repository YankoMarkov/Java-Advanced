import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedLoopsToRecursion {
	
	private static int numberOfLoops;
	private static int[] loops;
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		numberOfLoops = Integer.valueOf(read.readLine());
		loops = new int[numberOfLoops];
		
		nestedLoops(0);
	}
	
	private static void nestedLoops(int currentLoop) {
		if (currentLoop == numberOfLoops) {
			printLoops();
			return;
		}
		for (int counter = 1; counter <= numberOfLoops; counter++) {
			loops[currentLoop] = counter;
			nestedLoops(currentLoop + 1);
		}
	}
	
	private static void printLoops() {
		System.out.println(Arrays.toString(loops).replaceAll("[\\[\\],]", ""));
	}
}

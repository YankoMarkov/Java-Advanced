import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sorting {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		
		//bubbleSort(input);
		selectionSort(input);
		
		for (int i : input) {
			System.out.print(i + " ");
		}
	}
	
	private static void bubbleSort(int[] input) {
		boolean swapped = true;
		do {
			swapped = false;
			for (int i = 0; i < input.length - 1; i++) {
				if (input[i] > input[i + 1]) {
					swap(input, i, i + 1);
					swapped = true;
				}
			}
		} while (swapped);
	}
	
	private static void selectionSort(int[] input) {
		for (int index = 0; index < input.length; index++) {
			int min = index;
			for (int current = min + 1; current < input.length; current++) {
				if (input[min] > input[current]) {
					min = current;
				}
			}
			swap(input, index, min);
		}
	}
	
	private static void swap(int[] input, int index, int min) {
		int temp = input[index];
		input[index] = input[min];
		input[min] = temp;
	}
}

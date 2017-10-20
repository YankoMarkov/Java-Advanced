import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OverlappingIntervals {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		
		int[][] matrix = new int[num][2];
		
		for (int i = 0; i < num; i++) {
			int[] arr = Arrays.stream(read.readLine().split(",")).mapToInt(Integer::valueOf).toArray();
			matrix[i] = arr;
		}
		List<int[]> intervals = Arrays.stream(matrix).sorted(Comparator.comparing(arr -> arr[0])).collect(Collectors.toList());
		
		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i)[1] >= intervals.get(i + 1)[0]) {
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
	}
}


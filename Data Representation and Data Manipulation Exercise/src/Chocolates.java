import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chocolates {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.valueOf(read.readLine());
		int[] packets = Arrays.stream(read.readLine().split(", ")).mapToInt(Integer::valueOf).toArray();
		int students = Integer.valueOf(read.readLine());
		
		Arrays.sort(packets);
		
		int min = Integer.MAX_VALUE;
		int tempMin = 0;
		for (int i = 0; i < packets.length; i++) {
			if (i + students - 1 == packets.length) {
				break;
			}
			int first = packets[i];
			int last = packets[i + students - 1];
			tempMin = last - first;
			if (min > tempMin) {
				min = tempMin;
			}
		}
		System.out.printf("Min Difference is %d.", min);
	}
}

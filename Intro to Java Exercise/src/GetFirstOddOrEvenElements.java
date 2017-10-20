import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetFirstOddOrEvenElements {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int[] numInput = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
		String[] comInput = read.readLine().split("\\s+");
		int numOfElement = Integer.valueOf(comInput[1]);
		String oddOrEven = comInput[2];
		
		List<Integer> result = new ArrayList<>();
		int index = 0;
		
		for (int i = 0; i < numInput.length; i++) {
			if (index == numOfElement) {
				continue;
			}
			if (oddOrEven.equals("even")) {
				if (numInput[i] % 2 == 0) {
					result.add(numInput[i]);
					index++;
				}
			} else {
				if (numInput[i] % 2 != 0) {
					result.add(numInput[i]);
					index++;
				}
			}
		}
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

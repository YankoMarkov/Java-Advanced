import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.util.Arrays;

public class FindTheMissingNumber {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.valueOf(read.readLine());
		int[] array = Arrays.stream(read.readLine().split(", ")).mapToInt(Integer::valueOf).toArray();
		
		Arrays.sort(array);
		int num = 0;
		if (array.length == 1) {
			if (array[0] == 1) {
				System.out.println("2");
			} else {
				System.out.println("1");
			}
			return;
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] > 1) {
				num = array[i] - 1;
			}
			if (num == 0) {
				if (array[0] > 1) {
					num = 1;
				} else {
					num = number;
				}
			}
		}
		System.out.println(num);
	}
}

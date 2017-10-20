import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HitTheTarget {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.valueOf(read.readLine());
		
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				if (i + j == number) {
					System.out.printf("%s + %s = %s%n", i, j, number);
				} else if (i - j == number) {
					System.out.printf("%s - %s = %s%n", i, j, number);
				}
			}
		}
	}
}
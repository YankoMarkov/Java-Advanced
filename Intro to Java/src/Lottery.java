import java.io.BufferedReader;
		import java.io.InputStreamReader;

public class Lottery {
	
	public static void main(String[] args) {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int a = 1;
		int b = 10;
		
		for (int i = a; i <= b; i++) {
			for (int j = i; j <= b; j++) {
				for (int k = j; k <= b; k++) {
					if (i != j && i != k && j != k) {
						System.out.printf("%d %d %d%n", i, j, k);
					}
				}
			}
		}
	}
}

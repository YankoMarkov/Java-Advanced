import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Numbers0To9 {
	
	public static void main(String[] args) {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int number = 0;
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Number: " + number);
			number++;
		}
	}
}

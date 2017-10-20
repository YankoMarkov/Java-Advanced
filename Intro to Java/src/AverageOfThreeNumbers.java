import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageOfThreeNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = read.readLine().split("\\s+");
		double a = Double.valueOf(input[0]);
		double b = Double.valueOf(input[1]);
		double c = Double.valueOf(input[2]);
		
		double sum = a + b + c;
		double result = sum / 3;
		
		System.out.printf("%.2f", result);
	}
}

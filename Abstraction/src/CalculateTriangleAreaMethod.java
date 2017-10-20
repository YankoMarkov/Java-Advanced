import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateTriangleAreaMethod {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		
		double result = calculateArea(input);
		System.out.printf("Area = %.2f", result);
	}
	
	private static double calculateArea(String[] input) {
		double base = Double.valueOf(input[0]);
		double height = Double.valueOf(input[1]);
		
		return (base * height) / 2;
	}
}

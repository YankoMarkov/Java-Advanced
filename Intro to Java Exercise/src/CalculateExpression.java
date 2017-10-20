import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateExpression {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		double a = Double.valueOf(input[0]);
		double b = Double.valueOf(input[1]);
		double c = Double.valueOf(input[2]);
		
		double sqrF1 = (a + b + c) / Math.sqrt(c);
		double f1 = Math.pow(((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2))), sqrF1);
		double f2 = Math.pow((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3)), (a - b));
		double averageAbc = (a + b + c) / 3;
		double averageF1F2 = (f1 + f2) / 2;
		double abs = Math.abs(averageAbc - averageF1F2);
		
		System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, abs);
	}
}

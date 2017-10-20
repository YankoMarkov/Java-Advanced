import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransportPrice {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int kilometers = Integer.valueOf(read.readLine());
		String typeOfDay = read.readLine();
		double result = 0;
		
		if (kilometers < 20) {
			if (typeOfDay.equals("day")) {
				result = ((double) kilometers * 0.79) + 0.70;
				System.out.printf("%.2f", result);
			} else if (typeOfDay.equals("night")) {
				result = ((double) kilometers * 0.9) + 0.70;
				System.out.printf("%.2f", result);
			}
		} else if (kilometers < 100) {
			result = (double) kilometers * 0.09;
			System.out.printf("%.2f", result);
		} else {
			result = (double) kilometers * 0.06;
			System.out.printf("%.2f", result);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class EuroTrip {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		double input = Double.valueOf(read.readLine());
		double pricePerKilo = 1.20;
		BigDecimal priceInLevs = new BigDecimal(input * pricePerKilo);
		
		BigDecimal exchangeRate = new BigDecimal("4210500000000");
		BigDecimal result = priceInLevs.multiply(exchangeRate);
		
		System.out.printf("%.2f marks", result);
	}
}

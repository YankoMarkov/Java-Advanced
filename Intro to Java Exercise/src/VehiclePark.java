import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclePark {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> vehicles = Arrays.stream(read.readLine().split("\\s+")).collect(Collectors.toList());
		
		int soldVehicle = 0;
		String inputs = null;
		while (!(inputs = read.readLine()).equals("End of customers!")) {
			String[] input = inputs.toLowerCase().split("\\s+");
			String vehicle = input[0].charAt(0) + input[2];
			
			if (vehicles.contains(vehicle)) {
				int num = vehicle.charAt(0);
				int num1 = Integer.parseInt(vehicle.substring(1));
				int total = num * num1;
				System.out.printf("Yes, sold for %d$%n", total);
				vehicles.remove(vehicle);
				soldVehicle++;
			} else {
				System.out.println("No");
			}
		}
		System.out.print("Vehicles left: ");
		String result = vehicles.stream()
				.collect(Collectors.joining(", "));
		System.out.println(result);
		System.out.printf("Vehicles sold: %d", soldVehicle);
	}
}

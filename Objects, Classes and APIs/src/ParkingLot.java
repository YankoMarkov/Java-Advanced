import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs;
		Set<String> result = new HashSet<>();
		
		while (!(inputs = read.readLine()).equals("END")) {
			String[] input = inputs.split(", ");
			
			if (input[0].equals("IN")) {
				result.add(input[1]);
			}
			if (input[0].equals("OUT")) {
				result.remove(input[1]);
			}
		}
		if (result.isEmpty()) {
			System.out.println("Parking Lot is Empty");
		} else {
			for (String s : result) {
				System.out.println(s);
			}
		}
	}
}

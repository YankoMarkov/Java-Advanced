import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String inputs;
		Set<String> guests = new TreeSet<>();
		
		while (!(inputs = read.readLine()).equals("PARTY")) {
			guests.add(inputs);
		}
		while (!(inputs = read.readLine()).equals("END")) {
			guests.remove(inputs);
		}
		System.out.println(guests.size());
		for (String guest : guests) {
			System.out.println(guest);
		}
	}
}

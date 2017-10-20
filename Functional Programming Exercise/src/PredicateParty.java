import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateParty {
	private static Predicate<String> currentPredicate;
	private static List<String> names;
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		names = new ArrayList<>(Arrays.asList(read.readLine().split("\\s+")));
		String commands;
		
		while (!(commands = read.readLine()).equals("Party!")) {
			String[] command = commands.split("\\s+");
			
			Predicate<String> lengthPredicate = (string) -> string.length() == Integer.parseInt(command[2]);
			Predicate<String> startsWithPredicate = (string) -> string.startsWith(command[2]);
			Predicate<String> endsWithPredicate = (string) -> string.endsWith(command[2]);
			switch (command[1]) {
				case "Length":
					currentPredicate = lengthPredicate;
					break;
				case "StartsWith":
					currentPredicate = startsWithPredicate;
					break;
				case "EndsWith":
					currentPredicate = endsWithPredicate;
					break;
			}
			switch (command[0]) {
				case "Remove":
					names.removeIf(currentPredicate);
					break;
				case "Double":
					doubleArray();
					break;
			}
		}
		if (names.isEmpty()) {
			System.out.println("Nobody is going to the party!");
		} else {
			System.out.printf("%s are going to the party!%n", names.toString().replaceAll("[\\[\\]]", ""));
		}
	}
	
	private static void doubleArray() {
		List<String> result = new ArrayList<>();
		for (String s1 : names) {
			if (currentPredicate.test(s1)) {
				result.add(s1);
			}
			result.add(s1);
		}
		names = result;
	}
}
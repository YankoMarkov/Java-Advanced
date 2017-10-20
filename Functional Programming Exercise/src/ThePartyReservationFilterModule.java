import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> names = Arrays.stream(read.readLine().split("\\s+")).map(String::new).collect(Collectors.toList());
		List<String> finalCommands = new ArrayList<>();
		String commands;
		
		while (!(commands = read.readLine()).equals("Print")) {
			String[] command = commands.split(";");
			if (command[0].equals("Add filter")) {
				finalCommands.add(command[1] + ";" + command[2]);
			} else if (command[0].equals("Remove filter")) {
				finalCommands.remove(command[1] + ";" + command[2]);
			}
		}
		for (String command : finalCommands) {
			String[] finalCommand = command.split(";");
			names.removeAll(criteria(names, finalCommand[0], finalCommand[1]));
		}
		System.out.println(names.toString().replaceAll("[\\[\\],]", ""));
	}
	
	private static List<String> criteria(List<String> names, String condition, String word) {
		switch (condition) {
			case "Starts with":
				names = names.stream()
						.filter(a -> a.startsWith(word))
						.collect(Collectors.toList());
				break;
			case "Ends with":
				names = names.stream()
						.filter(a -> a.endsWith(word))
						.collect(Collectors.toList());
				break;
			case "Contains":
				names = names.stream()
						.filter(a -> a.contains(word))
						.collect(Collectors.toList());
				break;
			case "Length":
				int length = Integer.valueOf(word);
				names = names.stream()
						.filter(a -> a.length() == length)
						.collect(Collectors.toList());
				break;
		}
		return names;
	}
}

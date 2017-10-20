import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InfernoIII {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> inputs = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
		List<Integer> numbers = new ArrayList<>();
		numbers.add(0);
		numbers.addAll(inputs);
		numbers.add(0);
		List<String> finalCommands = new ArrayList<>();
		String commands;
		
		while (!(commands = read.readLine()).equals("Forge")) {
			String[] command = commands.split(";");
			if (command[0].equals("Exclude")) {
				finalCommands.add(command[1] + ";" + command[2]);
			} else if (command[0].equals("Reverse")) {
				finalCommands.remove(command[1] + ";" + command[2]);
			}
		}
		for (String command : finalCommands) {
			String[] finalCommand = command.split(";");
			inputs.removeAll(numbsForRemove(numbers, finalCommand[0], Integer.valueOf(finalCommand[1])));
		}
		System.out.println(inputs.toString().replaceAll("[\\[\\],]", ""));
	}
	
	private static List<Integer> numbsForRemove(List<Integer> numbers, String condition, int digit) {
		List<Integer> numbsForRemove = new ArrayList<>();
		switch (condition) {
			case "Sum Left":
				for (int i = 1; i < numbers.size() - 1; i++) {
					if (numbers.get(i) + numbers.get(i - 1) == digit) {
						numbsForRemove.add(numbers.get(i));
					}
				}
				break;
			case "Sum Right":
				for (int i = 1; i < numbers.size() - 1; i++) {
					if (numbers.get(i) + numbers.get(i + 1) == digit) {
						numbsForRemove.add(numbers.get(i));
					}
				}
				break;
			case "Sum Left Right":
				for (int i = 1; i < numbers.size() - 1; i++) {
					if (numbers.get(i - 1) + numbers.get(i) + numbers.get(i + 1) == digit) {
						numbsForRemove.add(numbers.get(i));
					}
				}
				break;
		}
		return numbsForRemove;
	}
}

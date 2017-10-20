import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppliedArithmetic {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> input = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
		String command;
		
		while (!(command = read.readLine()).equals("end")) {
			switch (command) {
				case "add":
					input = input.stream().map(a -> a + 1).collect(Collectors.toList());
					break;
				case "subtract":
					input = input.stream().map(a -> a - 1).collect(Collectors.toList());
					break;
				case "multiply":
					input = input.stream().map(a -> a * 2).collect(Collectors.toList());
					break;
				case "print":
					input.forEach(res -> System.out.print(res + " "));
					System.out.println();
					break;
			}
		}
	}
}

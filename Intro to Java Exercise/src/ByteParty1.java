import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteParty1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		List<Integer> numbers = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			numbers.add(Integer.valueOf(read.readLine()));
		}
		
		List<String> commandsList = new ArrayList<>();
		String commInput = null;
		while (!(commInput = read.readLine()).equals("party over")) {
			commandsList.add(commInput);
		}
		List<Integer> results = new ArrayList<>();
		
		for (int i = 0; i < numbers.size(); i++) {
			int result = numbers.get(i);
			
			for (String comm : commandsList) {
				int[] commands = Arrays.stream(comm.split("\\s+")).mapToInt(Integer::valueOf).toArray();
				int command = commands[0];
				int position = commands[1];
				int mask = 0;
				int tempResult = 0;
				
				switch (command) {
					case -1:
						mask = 1 << position;
						tempResult = result ^ mask;
						result = tempResult;
						break;
					case 1:
						mask = 1 << position;
						tempResult = result | mask;
						result = tempResult;
						break;
					case 0:
						mask = ~(1 << position);
						tempResult = result & mask;
						result = tempResult;
						break;
				}
			}
			results.add(result);
		}
		for (Integer result : results) {
			System.out.println(result);
		}
	}
}

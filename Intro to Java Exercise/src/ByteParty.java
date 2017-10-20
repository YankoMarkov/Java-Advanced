import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ByteParty {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		List<Integer> numbers = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			numbers.add(Integer.valueOf(read.readLine()));
		}
		
		List<String> commands = new ArrayList<>();
		String commInput = null;
		while (!(commInput = read.readLine()).equals("party over")) {
			commands.add(commInput);
		}
		
		for (Integer integer : numbers) {
			String temp = String.format("%8s", Integer.toString(integer, 2)).replace(" ", "0");
			StringBuilder tempRes = new StringBuilder(temp);
			tempRes = tempRes.reverse();
			
			for (int i = 0; i < commands.size(); i++) {
				String[] commPosition = commands.get(i).split("\\s+");
				int number = Integer.valueOf(commPosition[0]);
				int position = Integer.valueOf(commPosition[1]);
				
				if (number == -1) {
					if (tempRes.charAt(position) == '0') {
						tempRes.replace(position, position + 1, "1");
					} else {
						tempRes.replace(position, position + 1, "0");
					}
				}
				if (number == 0) {
					tempRes.replace(position, position + 1, "0");
				}
				if (number == 1) {
					tempRes.replace(position, position + 1, "1");
				}
			}
			String temporary = tempRes.reverse().toString();
			int result = Integer.parseInt(temporary, 2);
			System.out.println(result);
		}
	}
}

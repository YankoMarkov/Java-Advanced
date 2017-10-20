import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModifyABit {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		int number = Integer.valueOf(input[0]);
		int index = Integer.valueOf(input[1]);
		String value = input[2];
		
		String temp = String.format("%16s", Integer.toString(number, 2)).replace(" ", "0");
		StringBuilder res = new StringBuilder(temp);
		res = res.reverse();
		
		if (value.equals("1")) {
			res = res.replace(index, index + 1, "1");
		} else {
			res = res.replace(index, index + 1, "0");
		}
		
		res = res.reverse();
		String result = res.toString();
		int total = Integer.parseInt(result, 2);
		System.out.println(total);
	}
}

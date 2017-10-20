import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractABitFromInteger {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] input = read.readLine().split("\\s+");
		int number = Integer.valueOf(input[0]);
		int index = Integer.valueOf(input[1]);
		
		String temp = String.format("%16s", Integer.toString(number, 2)).replace(" ", "0");
		StringBuilder res = new StringBuilder(temp);
		String result = res.reverse().toString();
		
		System.out.println(result.charAt(index));
	}
}

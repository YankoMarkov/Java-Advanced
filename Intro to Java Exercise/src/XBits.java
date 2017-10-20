import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XBits {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> binaries = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			int number = Integer.valueOf(read.readLine());
			String temp = String.format("%32s", Integer.toString(number, 2)).replace(" ", "0");
			binaries.add(temp);
		}
		int counter = 0;
		for (int i = 0; i < binaries.size() - 2; i++) {
			for (int j = 0; j < binaries.get(i).length() - 2; j++) {
				String a = binaries.get(i).charAt(j) + "" + binaries.get(i).charAt(j + 1) + binaries.get(i).charAt(j + 2);
				String b = binaries.get(i + 1).charAt(j) + "" + binaries.get(i + 1).charAt(j + 1) + binaries.get(i + 1).charAt(j + 2);
				String c = binaries.get(i + 2).charAt(j) + "" + binaries.get(i + 2).charAt(j + 1) + binaries.get(i + 2).charAt(j + 2);
				
				if (a.equals("101") & b.equals("010") && c.equals("101")) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleTextEditor {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		Deque<String> stack = new ArrayDeque<>();
		String temp = "";
		
		for (int i = 0; i < num; i++) {
			String[] input = read.readLine().split("\\s+");
			int command = Integer.valueOf(input[0]);
			
			switch (command) {
				case 1:
					stack.push(temp);
					temp += input[1];
					break;
				case 2:
					stack.push(temp);
					int count = Integer.valueOf(input[1]);
					temp = temp.substring(0, temp.length() - count);
					break;
				case 3:
					int index = Integer.valueOf(input[1]);
					System.out.println(temp.charAt(index - 1));
					break;
				case 4:
					temp = stack.pop();
					break;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfNames {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(read.readLine());
		
		int maxScore = Integer.MIN_VALUE;
		int sumAscii = 0;
		String winnter = "";
		for (int i = 0; i < num; i++) {
			String name = read.readLine();
			int points = Integer.valueOf(read.readLine());
			int sum = 0;
			for (int j = 0; j < name.length(); j++) {
				int temp = name.charAt(j);
				if (temp % 2 == 0) {
					sum += temp;
				} else {
					sum -= temp;
				}
			}
			sumAscii = points + sum;
			if (sumAscii > maxScore) {
				maxScore = sumAscii;
				winnter = name;
			}
			sumAscii = 0;
		}
		System.out.printf("The winner is %s - %d points", winnter, maxScore);
	}
}
